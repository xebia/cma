package com.xebia.dependencies;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PropertyResolver {
	
	private File pomFile;
	
	private PropertyResolver parentResolver;
	
	private Map<String, String> propertyMap;

	public PropertyResolver(File pomFile, PropertyResolver parentResolver) {
		this.pomFile = pomFile;
		this.parentResolver = parentResolver;
	}

	public String resolve(String someId) {
		if (someId == null) {
			return null;
		}
		if (propertyMap == null) {
			try {
				init();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (! needsResolution(someId)) {
			return someId;
		}
		String resolvedValue = propertyMap.get(someId);
		if (resolvedValue == null) {
			if (parentResolver != null) {
				return parentResolver.resolve(someId);
			}
		}
		return resolvedValue;
	}

	private boolean needsResolution(String someId) {
		int first = someId.indexOf("${") ;
		int last = someId.lastIndexOf("}");
		return first == 0 && last == (someId.length() - 1);
	}

	private void init() throws Exception {
		propertyMap = new HashMap<String, String>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(pomFile);
		NodeList nList = doc.getElementsByTagName("properties");
		Node propertiesNode = (Node)nList.item(0);
		if (propertiesNode != null) {
			Element propertiesElement = (Element)propertiesNode;
			NodeList propertyList = propertiesElement.getChildNodes();
			// add ${project.version} and  ${project.groupId}
			String projectVersion = null;
			String projectGroupId = null;
			Node parentOfPropertiesNode = propertiesElement.getParentNode();
			Element parentOfPropertiesElement = (Element)parentOfPropertiesNode;
			NodeList childList = parentOfPropertiesElement.getChildNodes();
			for (int i = 0; i < childList.getLength(); i++) {
				Node childNode = childList.item(i);
				if (Node.ELEMENT_NODE == childNode.getNodeType()) {
					Element versionElement = (Element)childNode;
					if (versionElement.getTagName().equals("version")) {
						String version = versionElement.getTextContent();
						propertyMap.put("${project.version}", version);
						projectVersion = version;
					} else if (versionElement.getTagName().equals("groupId")) {
						String groupId = versionElement.getTextContent();
						propertyMap.put("${project.groupId}", groupId);
						projectGroupId = groupId;
					} 
				}
			}
			for (int i = 0; i < propertyList.getLength(); i++) {
				Node propertyNode = (Node)propertyList.item(i);
				if (Node.ELEMENT_NODE == propertyNode.getNodeType()) {
					Element propertyElement = (Element)propertyNode;
					String tagName = propertyElement.getTagName();
					String content = propertyElement.getTextContent();
					if (content.equals("${project.version}") && projectVersion != null) {
						propertyMap.put("${" + tagName + "}", projectVersion);
					} else if (content.equals("${project.groupId}") && projectGroupId != null) {
						propertyMap.put("${" + tagName + "}", projectGroupId);
					} else {
						propertyMap.put("${" + tagName + "}", content);
					}
				}
			}
		}
	}

}
