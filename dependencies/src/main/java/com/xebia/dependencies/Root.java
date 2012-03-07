package com.xebia.dependencies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Root {
	
	private List<Item> allItems;
	
	public Root() {
		this.allItems = new ArrayList<Item>();
	}

	public List<Item> getAllItems() {
		return allItems;
	}

	public void setAllItems(Collection<Item> allItems) {
		this.allItems.addAll(allItems);
	}
	
	public static void main(String[] args) {
		Root root = new Root();
		root.setAllItems(new ArrayList<Item>());

		System.out.println("Initial adjacency list:");
		root.print();
		root.transclos();
		System.out.println("Transitive close of adjacency list:");
		root.print();
		Set<Cycle> cycles = root.findCycles();
		System.out.println("all cycles:");
		for (Cycle cycle : cycles) {
			cycle.print();
		}
	}


	public Set<Cycle> findCycles() {
		Set<Cycle> cycles = new HashSet<Cycle>();
		for (Item item : getAllItems()) {
			if (item.isPartOfCycle()) {
				List<Cycle> cyclesThatItemIsPartOf = item.findCyclesThatItemIsPartOf();
				if (cyclesThatItemIsPartOf != null && cyclesThatItemIsPartOf.size() > 0) {
					cycles.addAll(cyclesThatItemIsPartOf);
				}
			}
		}
		return cycles;
	}

	public void transclos() {
		boolean somethingChanged = true;
		while (somethingChanged) {
			somethingChanged = false;
			for (Item item : getAllItems()) {
				Set<Item> reachables = item.getReachableIems();
				if (reachables != null && reachables.size() != 0) {
					Set<Item> reachablesToAdd = new HashSet<Item>();
					for (Item reachable : reachables) {
						Set<Item> reachablesFromReachable = reachable.getReachableIems();
						if (reachablesFromReachable != null && reachablesFromReachable.size() != 0) {
							for (Item reachableFromReachable : reachablesFromReachable) {
								if (! item.alreadyReachable(reachableFromReachable)) {
									reachablesToAdd.add(reachableFromReachable);
									somethingChanged = true;
								}
							}
						}
					}
					item.getReachableIems().addAll(reachablesToAdd);
				}
			}
	}
	}
	
	private void print() {
		for (Item item : getAllItems()) {
			System.out.println(item.toString());
		}
	}

	public void readFile(String fileName) throws IOException {
		Map<String, String[]> tempStore = parseFile(fileName);
		addItemsWithoutReachables(tempStore);
		addReachablesToPlainItems(tempStore);
	}

	private Map<String, String[]> parseFile(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName)));
		String line;
		Map<String, String[]> tempStore = new HashMap<String, String[]>();
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split("->");
			String itemId = parts[0];
			if (!itemId.equals("")) {
				if (parts.length > 1) {
					String[] ids = parts[1].split(",");
					tempStore.put(itemId, ids);
				} else {
					tempStore.put(itemId, null);
				}
			} else {
				System.out.println("Warning: no Id found in line: " + line);
			}
		}
		return tempStore;
	}

	private void addReachablesToPlainItems(Map<String, String[]> tempStore) {
		for (String id : tempStore.keySet()) {
			Item item = lookupItemById(id);
			String[] idsOfReachableItems = tempStore.get(id);
			if (idsOfReachableItems != null && idsOfReachableItems.length > 0) {
				for (String idOfReachable : idsOfReachableItems) {
					Item reachable = lookupItemById(idOfReachable);
					item.getReachableIems().add(reachable);
				}
			}
		}
	}

	private void addItemsWithoutReachables(Map<String, String[]> tempStore) {
		for (String id : tempStore.keySet()) {
			Item item = new Item(id);
			getAllItems().add(item);
		}
	}

	public Item lookupItemById(String id) {
		List<Item> allItems = getAllItems();
		if (allItems == null || allItems.size() == 0) {
			throw new RuntimeException("Item with id: " + id + " is referenced but not defined");
		}
		for (Item item : allItems) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		throw new RuntimeException("Item with id: " + id + " is referenced but not defined");
	}
}
