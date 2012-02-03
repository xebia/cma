package com.xebia.dependencies;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Dependency {
	
	private String groupId;
	private String artifactId;
	private String version;
	private File dependentPomFile;
	private boolean childDependenciesAreAlreadyRead;
	
	private List<Dependency> dependencies = new ArrayList<Dependency>();
	
	private PropertyResolver propertyResolver;

	private Dependency parent;
	
	private static final String M2_REPO = "/Users/wilco/.m2/repository/";
	
	public Dependency(String groupId, String artifactId, String version, File dependentPomFile, boolean childDependenciesAreAlreadyRead, Dependency parent) {
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
		this.dependentPomFile = dependentPomFile;
		this.childDependenciesAreAlreadyRead = childDependenciesAreAlreadyRead;
		this.parent = parent;
	}
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getArtifactId() {
		return artifactId;
	}
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public File getDependentPomFile() {
		return dependentPomFile;
	}

	public void setDependentPomFile(File dependentPomFile) {
		this.dependentPomFile = dependentPomFile;
	}

	public boolean isChildDependenciesAreAlreadyRead() {
		return childDependenciesAreAlreadyRead;
	}

	public void setChildDependenciesAreAlreadyRead(boolean childDependenciesAreAlreadyRead) {
		this.childDependenciesAreAlreadyRead = childDependenciesAreAlreadyRead;
	}

	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Dependency> dependencies) {
		this.dependencies = dependencies;
	}

	public Dependency getParent() {
		return parent;
	}

	public void setParent(Dependency parent) {
		this.parent = parent;
	}

	public void readDependentChildren() {
		try {
			pomFileToAdjacencyList();
			childDependenciesAreAlreadyRead = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void pomFileToAdjacencyList() throws Exception {
		if (! dependentPomFile.exists()) {
			System.out.println("file " + dependentPomFile.getAbsolutePath() + " does not exist");
			return;
		}
		
		dependencies = new ArrayList<Dependency>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(dependentPomFile);
		NodeList nList = doc.getElementsByTagName("dependencies");
		
		if (parent != null) {
			propertyResolver = new PropertyResolver(dependentPomFile, parent.getPropertyResolver());
		} else {
			propertyResolver = new PropertyResolver(dependentPomFile, null);
		}
		
		if (nList != null && nList.getLength() != 0) {
			if (nList.getLength() == 1) {
				Node dependenciesNode = nList.item(0);
				if (Node.ELEMENT_NODE == dependenciesNode.getNodeType()) {
					Element el = (Element)dependenciesNode;
					NodeList dependencyList = el.getElementsByTagName("dependency");
					System.out.println("found " + dependencyList.getLength() + " dependencies in File: " + dependentPomFile.getAbsolutePath());
					for (int i = 0; i < dependencyList.getLength(); i++) {
						Node dependencyNode = dependencyList.item(i);
						Element dependencyNodeAsElement = (Element)dependencyNode;
						
						String groupId = propertyResolver.resolve(getGroupId(dependencyNodeAsElement));
						String artifactId = propertyResolver.resolve(getArtifactId(dependencyNodeAsElement));
						String version = propertyResolver.resolve(getVersion(dependencyNodeAsElement));
						
						if (version == null) {
							System.out.println("while handling pomFile: " + dependentPomFile.getAbsolutePath() + " I did not find a version for groupId " + groupId + " artId: " + artifactId);
						} else {
							System.out.println("found dep on " + groupId + " artId: " + artifactId + " version: " + version);
							
							File dependentPomFile = new File (M2_REPO + makePathToDependentPom(groupId, artifactId, version));
							dependencies.add(new Dependency(groupId, artifactId, version, dependentPomFile, false, this));
						}
					}
				}
			} else { 
				System.out.println("can't handle other than 1 dependencies element in a single pom file " + dependentPomFile.getAbsolutePath() + " I got " + nList.getLength());
			}
		}
	}
	
	private PropertyResolver getPropertyResolver() {
		return propertyResolver;
	}
	
	private String makePathToDependentPom(String groupId, String artifactId, String version) {
		String groupIdPath = groupIdToPath(groupId);
		return groupIdPath + "/" + artifactId + "/" + version + "/" + artifactId + "-" + version + ".pom";
	}

	private String groupIdToPath(String groupId) {
		return groupId.replaceAll("\\.", "/");
	}

	private String getGroupId(Element dependencyNodeAsElement) {
		NodeList groupIdNodes = dependencyNodeAsElement.getElementsByTagName("groupId");
		Node groupIdNode = groupIdNodes.item(0);
		Element groupIdElement = (Element)groupIdNode;
		return groupIdElement.getTextContent();
	}

	private String getArtifactId(Element dependencyNodeAsElement) {
		NodeList artifactIdNodes = dependencyNodeAsElement.getElementsByTagName("artifactId");
		Node artifactIdNode = artifactIdNodes.item(0);
		Element artifactIdElement = (Element)artifactIdNode;
		return artifactIdElement.getTextContent();
	}

	private String getVersion(Element dependencyNodeAsElement) {
		NodeList versionNodes = dependencyNodeAsElement.getElementsByTagName("version");
		if (versionNodes.getLength() != 0) {
			Node versionNode = versionNodes.item(0);
			Element versionElement = (Element)versionNode;
			return versionElement.getTextContent();
		} else {
			return null;
		}
	}
}
