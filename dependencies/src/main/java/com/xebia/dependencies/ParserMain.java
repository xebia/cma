package com.xebia.dependencies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import com.xebia.xal.parser.xalLexer;
import com.xebia.xal.parser.xalParser;

public class ParserMain {

	public static void main(String[] args) throws Exception {
		ParserMain parserMain = new ParserMain();
		parserMain.go(args);
	}
	
	private void go(String[] args) throws Exception {

		handleSingleFile("Example.adl");
		
		handleFolder("Archive");

	}

	private void handleFolder(String folderName) throws URISyntaxException, IOException, RecognitionException {
		URL resource = this.getClass().getClassLoader().getResource(folderName);
		if (resource != null) {
			File archiveFolder = new File(resource.toURI());
			if (archiveFolder.exists() && archiveFolder.isDirectory()) {
				Map<String, SymbolTableAndTree> compositeSymbolTableAndTrees = new HashMap<String, SymbolTableAndTree>();
				File[] allFilesInArchive = archiveFolder.listFiles();
				for (File fileInArchive : allFilesInArchive) {
					if (fileInArchive.getPath().endsWith("adl")) {
						SymbolTableAndTree symbolTableAndTree = getSymbolTableAndTreeFromSingleFile(fileInArchive.getPath());
						compositeSymbolTableAndTrees.put(fileInArchive.getPath(), symbolTableAndTree);
					}
				}
				for (File fileInArchive : allFilesInArchive) {
					if (fileInArchive.getPath().endsWith("adl")) {
						 checkSingleFile(fileInArchive.getPath(), compositeSymbolTableAndTrees);
					}
				}
 			}
		} else {
			System.out.println("Can't read Archive");
		}
	}
	
	private SymbolTableAndTree getSymbolTableAndTreeFromSingleFile(String filename) throws IOException, RecognitionException {
		CommonTree theTree = buildTree(filename);
		
		SymbolTable symbolTable = buildSymbolTable(theTree);
		
		printOverview(symbolTable);
		
		SymbolTableAndTree symbolTableAndTree = new SymbolTableAndTree(symbolTable, theTree);
		return symbolTableAndTree;

	}

	private CommonTree buildTree(String filename) throws FileNotFoundException, IOException, RecognitionException {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Handling file: " + filename);
		System.out.println("");
		InputStream in = null;
		if (filename.startsWith("/")) {
			in = new FileInputStream(new File(filename));
		} else {
			in = this.getClass().getClassLoader().getResourceAsStream(filename);
		}
		CharStream input = new ANTLRInputStream(in);

		xalLexer lex = new xalLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		xalParser parser = new xalParser(tokens);
		xalParser.prog_return r = parser.prog();

		CommonTree theTree = (CommonTree) r.getTree();
		return theTree;
	}

	private void handleSingleFile(String filename) throws IOException, RecognitionException {
		Map<String, SymbolTableAndTree> compositeSymbolTableAndTrees = new HashMap<String, SymbolTableAndTree>();
		SymbolTableAndTree symbolTableAndTree = getSymbolTableAndTreeFromSingleFile(filename);
		compositeSymbolTableAndTrees.put(filename, symbolTableAndTree);
		
		checkSingleFile(filename, compositeSymbolTableAndTrees);
	}
	
	

	private void checkSingleFile(String filename, Map<String, SymbolTableAndTree> compositeSymbolTableAndTrees) {
		List<SymbolTable> additionalSymbolTables = getAdditionalSymbolTables(filename, compositeSymbolTableAndTrees);
		checkDefinition(compositeSymbolTableAndTrees.get(filename).getSymbolTable(), additionalSymbolTables);
	}

	private List<SymbolTable> getAdditionalSymbolTables(String filename, Map<String, SymbolTableAndTree> compositeSymbolTableAndTrees) {
		List<SymbolTable> additionalSymbolTables = new ArrayList<SymbolTable>();
		if (compositeSymbolTableAndTrees != null) {
			for (String key : compositeSymbolTableAndTrees.keySet()) {
				if (!key.equals(filename)) {
					additionalSymbolTables.add(compositeSymbolTableAndTrees.get(key).getSymbolTable());
				}
			}
		}
		return additionalSymbolTables;
	}

	private void checkDefinition(SymbolTable symbolTable, List<SymbolTable> additionalSymbolTables) {
		// TODO use the additionals!!!
		checkRhsIsImplementedByAreAllDefined(symbolTable);
		checkRhsDependsAreAllDefined(symbolTable, additionalSymbolTables);
		checkRhsIsDeployedOnAreAllDefined(symbolTable);
	}

	private SymbolTable buildSymbolTable(CommonTree t) {
		SymbolTable symbolTable = new SymbolTable();
		
		for (int childIndex = 0; childIndex < t.getChildCount(); childIndex++) {
			Tree child = t.getChild(childIndex);
			if (child.getChildCount() == 1) {
				// collect types and atomic definitions
				Tree type = child.getChild(0);
				String typeAsString = type.getText();
				symbolTable.getUsedTypes().add(typeAsString);
				String childText = child.getText();
				symbolTable.getDefinedComponents().add(childText);
			} else if (child.getChildCount() == 2) {
				// collect used components
				String relationText = child.getChild(0).getText();
				String usedComponentText = child.getChild(1).getText();
				if (relationText.equals("depends on")) {
					symbolTable.getRhsOfDependsOnComponents().add(usedComponentText);
				} else if (relationText.equals("is implemented by")) {
					symbolTable.getRhsOfIsImplementedByComponents().add(usedComponentText);
				} else if (relationText.equals("is deployed on")) {
					symbolTable.getRhsOfDeployedOnComponents().add(usedComponentText);
					addLhsToAllItemsUnlessAlreadyDefined(symbolTable.getAllItems(), child.getText());
					Item lhs = findItem(symbolTable.getAllItems(), child.getText());
					addRhsToAllItemsUnlessAlreadyDefined(symbolTable.getAllItems(), usedComponentText);
					Item rhs = findItem(symbolTable.getAllItems(), usedComponentText);
					if (!lhs.alreadyReachable(rhs)) {
						lhs.getReachableIems().add(rhs);
					}
				}
			}
		}
		return symbolTable;
	}

	private void printOverview(SymbolTable symbolTable) {
		System.out.println("all types used:");
		System.out.println(symbolTable.getUsedTypes());
		System.out.println("all atomic components defined:");
		System.out.println(symbolTable.getDefinedComponents());
		System.out.println("all components used at rhs of 'depends on':");
		System.out.println(symbolTable.getRhsOfDependsOnComponents());
		System.out.println("all components used at rhs of 'is implemented by':");
		System.out.println(symbolTable.getRhsOfIsImplementedByComponents());
		System.out.println("all components used at rhs of 'is deployed on':");
		System.out.println(symbolTable.getRhsOfDeployedOnComponents());
	}
	
	private Item findItem(Set<Item> allItems, String text) {
		if (allItems == null || allItems.size() == 0) {
			return null;
		}
		for (Item item : allItems) {
			if (item.getId().equals(text)) {
				return item;
			}
		}
		return null;
	}

	private void addLhsToAllItemsUnlessAlreadyDefined(Set<Item> allItems, String text) {
		addRhsOrLhsToAllItemsUnlessAlreadyDefined(allItems, text);
	}
	
	private void addRhsToAllItemsUnlessAlreadyDefined(Set<Item> allItems, String text) {
		addRhsOrLhsToAllItemsUnlessAlreadyDefined(allItems, text);
	}
	
	private void addRhsOrLhsToAllItemsUnlessAlreadyDefined(Set<Item> allItems, String text) {
		Item item = new Item(text);
		if (!allItems.contains(item)) {
			allItems.add(item);
		}
	}

	private void checkRhsIsDeployedOnAreAllDefined(SymbolTable symbolTable) {
		String header = "Checking that all rhs components of 'is deployed on' are defined, recursively";
		// each component in rhsOfDependsOnComponents must b defined
		symbolTable.getRoot().setAllItems(symbolTable.getAllItems());
		symbolTable.getRoot().transclos();
		if (symbolTable.getRhsOfDeployedOnComponents() == null || symbolTable.getRhsOfDeployedOnComponents().size() == 0) {
			return;
		}
		boolean headerIsPrinted = false;
		for (String component : symbolTable.getRhsOfDeployedOnComponents()) {
			if (! symbolTable.getDefinedComponents().contains(component)) {
				// see if a reachable item of the rhs is defined component. If so, we're OK
				Item rhsAsItem = symbolTable.getRoot().lookupItemById(component);
				Set<Item> reachableIems = rhsAsItem.getReachableIems();
				if (!anyReachableItemIsDefined(reachableIems, symbolTable.getDefinedComponents())) {
					if (! headerIsPrinted) {
						System.out.println(header);
						headerIsPrinted = true;
					}
					System.out.println("ERROR: " + component + " is used at the right hand side of a 'is deployed on' relation, but it is not defined");
				}
			}
		}
	}
	
	private boolean anyReachableItemIsDefined(Set<Item> reachableIems, Set<String> definedComponents) {
		if (reachableIems == null || reachableIems.size() == 0) {
			return false;
		}
		for (Item reachableItem : reachableIems) {
			if (definedComponents.contains(reachableItem.getId())) {
				return true;
			}
		}
		return false;
	}

	private void checkRhsDependsAreAllDefined(SymbolTable symbolTable, List<SymbolTable> additionalSymbolTables) {
		String header = "Checking that all rhs components of 'depends on' are defined";
		// each component in rhsOfDependsOnComponents must b defined
		if (symbolTable.getRhsOfDependsOnComponents() == null || symbolTable.getRhsOfDependsOnComponents().size() == 0) {
			return;
		}
		boolean headerIsPrinted = false;
		for (String component : symbolTable.getRhsOfDependsOnComponents()) {
			if (! symbolTable.getDefinedComponents().contains(component)) {
				if (!additionalSymbolTablesContain(component, additionalSymbolTables)) {
					if (! headerIsPrinted) {
						System.out.println(header);
						headerIsPrinted = true;
					}
					System.out.println("ERROR: " + component + " is used at the right hand side of a 'depends on' relation, but it is not defined");
				}
			}
		}
	}

	private boolean additionalSymbolTablesContain(String component, List<SymbolTable> additionalSymbolTables) {
		if (additionalSymbolTables == null || additionalSymbolTables.size() == 0) {
			return false;
		}
		for (SymbolTable symbolTable : additionalSymbolTables) {
			if (symbolTable.getDefinedComponents().contains(component)) {
				return true;
			}
		}
		return false;
	}

	private void checkRhsIsImplementedByAreAllDefined(SymbolTable symbolTable) {
		String header = "Checking that all rhs components of 'is implemented by' are defined";
		// each component in rhsOfIsImplementedByComponents must b defined
		if (symbolTable.getRhsOfIsImplementedByComponents() == null || symbolTable.getRhsOfIsImplementedByComponents().size() == 0) {
			return;
		}
		boolean headerIsPrinted = false;
		for (String component : symbolTable.getRhsOfIsImplementedByComponents()) {
			if (! symbolTable.getDefinedComponents().contains(component)) {
				if (! headerIsPrinted) {
					System.out.println(header);
					headerIsPrinted = true;
				}
				System.out.println("ERROR: " + component + " is used at the right hand side of a 'is implemented by' relation, but it is not defined");
			}
		}
	}

}
