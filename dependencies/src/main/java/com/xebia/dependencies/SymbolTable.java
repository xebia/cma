package com.xebia.dependencies;

import java.util.HashSet;
import java.util.Set;

public class SymbolTable {

	private Set<String> usedTypes;
	private Set<String> definedComponents;
	private Set<String> rhsOfDependsOnComponents;
	private Set<String> rhsOfIsImplementedByComponents;
	private Set<String> rhsOfDeployedOnComponents;
	private Set<Item> allItems;
	private Root root;
	
	public SymbolTable() {
		this.usedTypes = new HashSet<String>();
		this.definedComponents = new HashSet<String>();
		this.rhsOfDependsOnComponents = new HashSet<String>();
		this.rhsOfIsImplementedByComponents = new HashSet<String>();
		this.rhsOfDeployedOnComponents = new HashSet<String>();
		this.allItems = new HashSet<Item>();
		this.root = new Root();
	}
	
	public Set<String> getUsedTypes() {
		return usedTypes;
	}
	public void setUsedTypes(Set<String> usedTypes) {
		this.usedTypes = usedTypes;
	}
	public Set<String> getDefinedComponents() {
		return definedComponents;
	}
	public void setDefinedComponents(Set<String> definedComponents) {
		this.definedComponents = definedComponents;
	}
	public Set<String> getRhsOfDependsOnComponents() {
		return rhsOfDependsOnComponents;
	}
	public void setRhsOfDependsOnComponents(Set<String> rhsOfDependsOnComponents) {
		this.rhsOfDependsOnComponents = rhsOfDependsOnComponents;
	}
	public Set<String> getRhsOfIsImplementedByComponents() {
		return rhsOfIsImplementedByComponents;
	}
	public void setRhsOfIsImplementedByComponents(Set<String> rhsOfIsImplementedByComponents) {
		this.rhsOfIsImplementedByComponents = rhsOfIsImplementedByComponents;
	}
	public Set<String> getRhsOfDeployedOnComponents() {
		return rhsOfDeployedOnComponents;
	}
	public void setRhsOfDeployedOnComponents(Set<String> rhsOfDeployedOnComponents) {
		this.rhsOfDeployedOnComponents = rhsOfDeployedOnComponents;
	}
	public Set<Item> getAllItems() {
		return allItems;
	}
	public void setAllItems(Set<Item> allItems) {
		this.allItems = allItems;
	}

	public Root getRoot() {
		return root;
	}

	public void setRoot(Root root) {
		this.root = root;
	}
	
	
}
