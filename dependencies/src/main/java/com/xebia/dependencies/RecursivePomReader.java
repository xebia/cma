package com.xebia.dependencies;

import java.io.File;

public class RecursivePomReader {
	
	public static void main(String[] args) {
		File pomFile = new File("/Users/wilco/Documents/workspace/prorail/trunk/pub/pom.xml");
		Dependency parent = null;
		boolean childDependenciesAreAlreadyRead = false;
		Dependency dep = new Dependency("mainGroupId", "mainArtifactId", "mainVersion", pomFile, childDependenciesAreAlreadyRead, parent);
		
		RecursivePomReader recursivePomReader = new RecursivePomReader();
		recursivePomReader.read(dep);
	}

	private void read(Dependency dep) {
		Dependency dependencyForWhichChildrenAreNotRead = findDependencyForWhichChildrenAreNotRead(dep);
		
		while (dependencyForWhichChildrenAreNotRead != null) {
			dependencyForWhichChildrenAreNotRead.readDependentChildren();
			dependencyForWhichChildrenAreNotRead = findDependencyForWhichChildrenAreNotRead(dep);
		}
	}

	private Dependency findDependencyForWhichChildrenAreNotRead(Dependency dep) {
		if (! dep.isChildDependenciesAreAlreadyRead()) {
			return dep;
		}
		for (Dependency childDep : dep.getDependencies()) {
			Dependency candidate = findDependencyForWhichChildrenAreNotRead(childDep);
			if (candidate != null) {
				return candidate;
			}
		}
		return null;
	}

}
