package com.xebia.dependencies;

import org.antlr.runtime.tree.CommonTree;

public class SymbolTableAndTree {
	
	private SymbolTable symbolTable;
	private CommonTree tree;

	public SymbolTableAndTree(SymbolTable symbolTable, CommonTree tree) {
		this.symbolTable = symbolTable;
		this.tree = tree;
	}

	public SymbolTable getSymbolTable() {
		return symbolTable;
	}

	public void setSymbolTable(SymbolTable symbolTable) {
		this.symbolTable = symbolTable;
	}

	public CommonTree getTree() {
		return tree;
	}

	public void setTree(CommonTree tree) {
		this.tree = tree;
	}
	
	
}
