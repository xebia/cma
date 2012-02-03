package com.xebia.dependencies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Item {
	
	private String id;
	
	private Set<Item> reachableIems;
	
	public Item(String id) {
		this.id = id;
		this.reachableIems = new HashSet<Item>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Item> getReachableIems() {
		return reachableIems;
	}

	public void setReachableIems(Set<Item> reachableIems) {
		this.reachableIems = reachableIems;
	}
	
	public String toString() {
		return getId() + "=>" + reachableItemsAsString(getReachableIems());
	}

	private String reachableItemsAsString(Set<Item> items) {
		if (items == null || items.size() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Item item : items) {
			if (!first) {
				sb.append("-");
			} else {
				first = false;
			}
			sb.append(item.getId());
		}
		return sb.toString();
	}

	public boolean alreadyReachable(Item item) {
		return getReachableIems().contains(item);
	}

	@Override
	public boolean equals(Object that) {
		return this.getId().equals(((Item)that).getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	public boolean isPartOfCycle() {
		return getReachableIems().contains(this);
	}

	public List<Cycle> findCyclesThatItemIsPartOf() {
		if (! isPartOfCycle()) {
			return null; 
		}
		Set<Item> subset = new HashSet<Item>();
		subset.add(this);
		for (Item reachableItem : getReachableIems()) {
			if (reachableItem.getReachableIems().containsAll(subset)) {
				subset.add(reachableItem);
			}
		}
		Cycle cycle = new Cycle(subset); // TODO generalize, one will do for now
		List<Cycle> allCycles = new ArrayList<Cycle>();
		allCycles.add(cycle);
		return allCycles;
	}
	
	

}
