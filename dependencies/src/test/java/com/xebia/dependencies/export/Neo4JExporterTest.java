package com.xebia.dependencies.export;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.EmbeddedGraphDatabase;

import com.xebia.dependencies.Item;
import com.xebia.dependencies.Root;


public class Neo4JExporterTest {
    @Test
    public void shouldExportNodes() throws Exception {
        // Set up database
        Root root = new Root();
        root.readFile("sixNodesWithFourNodesCycle.cma");

        List<Item> items = root.getAllItems();
        assertThat(items.size(), not(0));

        EmbeddedGraphDatabase graphDb = new EmbeddedGraphDatabase("/tmp/neotestdatabaseforcma");

        Transaction tx = graphDb.beginTx();
        try
        {
            Map<String, Node> nodes = new HashMap<String, Node>();
            for(Item i : items) {
                Node node = graphDb.createNode();
                node.setProperty("id", i.getId());
                nodes.put(i.getId(), node);
            }
            //Create links
            RelationshipType defaultRelationship = DynamicRelationshipType.withName( "other item" );
            for(Item i : items) {
                Node a = nodes.get(i.getId());
                for(Item reachable : i.getReachableIems()) {
                    Node b = nodes.get(reachable.getId());
                    a.createRelationshipTo(b, defaultRelationship);
                }
            }
            tx.success();
        }
        finally
        {
            tx.finish();
        }

        graphDb.shutdown();
    }
}
