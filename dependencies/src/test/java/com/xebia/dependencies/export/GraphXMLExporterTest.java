package com.xebia.dependencies.export;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.xebia.dependencies.Root;


public class GraphXMLExporterTest {
	
    @Test
    public void exportGraphToGraphXML() throws IOException {
        // Set up database
        Root root = new Root();
        root.readFile("sixNodesWithFourNodesCycle.cma");
        
        GraphXMLExporter export = new GraphXMLExporter();
        File file = new File(System.getProperty("java.io.tmpdir"), "cma-to-graphxml.xml");
        file.delete();
        export.toFile(root, file);
        assertTrue(file.exists());
    }
}
