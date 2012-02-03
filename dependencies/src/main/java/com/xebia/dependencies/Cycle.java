package com.xebia.dependencies;

import java.util.Set;

public class Cycle {
	
	private Set<Item> items;
	
	public Cycle(Set<Item> items) {
		this.items = items;
	}

	public void print() {
		if (items == null || items.size() == 0) {
			System.out.println("");
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
		System.out.println(sb.toString());
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cycle other = (Cycle) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

}
