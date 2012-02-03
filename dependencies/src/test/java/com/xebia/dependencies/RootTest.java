package com.xebia.dependencies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RootTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testReadFileWithOneCycle() {
		Root root = new Root();
		boolean exceptionSeen = false;
		try {
			root.readFile("sixNodesWithFourNodesCycle.cma");
		} catch (Exception e) {
			exceptionSeen = true;
		}
		assertFalse(exceptionSeen);
		assertEquals("Number of items read", 6, root.getAllItems().size());
		
		root.transclos();

		Set<Cycle> cycles = root.findCycles();
		assertEquals("Number of cycles", 1, cycles.size());
		Cycle cycle = cycles.iterator().next();
		Set<Item> itemsInCycle = cycle.getItems();
		
		assertEquals("Number of items in cycle", 4, itemsInCycle.size());
	}
	
	@Test
	public void testReadFileWithTwoCycles() {
		Root root = new Root();
		boolean exceptionSeen = false;
		try {
			root.readFile("fifteenNodesWithoneCycleOfElevenNodes.cma");
		} catch (Exception e) {
			exceptionSeen = true;
		}
		assertFalse(exceptionSeen);
		assertEquals("Number of items read", 15, root.getAllItems().size());
		
		root.transclos();

		Set<Cycle> cycles = root.findCycles();
		assertEquals("Number of cycles", 1, cycles.size());
		Iterator<Cycle> iterator = cycles.iterator();
		Cycle cycleOne = iterator.next();
		
		assertEquals("Number of items in shortest cycle", 11, cycleOne.getItems().size());
	}

}
