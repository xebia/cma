package com.xebia.dependencies.export;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.xebia.dependencies.Root;

public class GraphXMLExporter {

	private Template template = null;
	private String templateName = "GraphXMLTemplate.vm";

	public GraphXMLExporter() {
		Properties properties = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("velocity.properties");
		try {
			if (inputStream != null) {
				properties.load(inputStream);
				Velocity.init(properties);
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to initialize velocity engine", e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * loads the velocity template with name 'templateName' into 'template.
	 */
	protected void loadVelocityTemplate() {
		try {
			template = Velocity.getTemplate(templateName);
		} catch (ResourceNotFoundException e) {
			throw new RuntimeException(String.format("Could not find template %s", templateName), e);
		} catch (ParseErrorException e) {
			throw new RuntimeException(String.format("parse error in template %s", templateName), e);
		} catch (MethodInvocationException e) {
			throw new RuntimeException(String.format("programming error in template %s", templateName), e);
		}
	}

	/**
	 * writes the graph from the 'root' to 'file' in GraphXML format.
	 * 
	 * @param root
	 *            of the tree.
	 * @param file
	 *            to write to.
	 */
	protected void writeToGraphXMLFile(Root root, File file) {
		assert template != null;

		VelocityContext context = new VelocityContext();
		context.put("root", root);
		Writer writer = null;
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			writer = new OutputStreamWriter(outputStream, "utf-8");
			template.merge(context, writer);
			writer.close();
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(String.format("error generating output using template %s", templateName), e);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(String.format("Cannot export to file %s.", file.getName()), e);
		} catch (IOException e) {
			throw new RuntimeException(String.format("Failed to export to file %s", file.getName()), e);
		}
	}

	public void toFile(Root root, File file) {
		if (template == null) {
			loadVelocityTemplate();
		}
		writeToGraphXMLFile(root, file);
	}
}
