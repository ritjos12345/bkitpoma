package com.bkitmobile.poma.util.server.kml;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Kml {

	protected NetworkLinkControl networkLinkControl;
	protected Feature feature;
	protected boolean celestialData = false;
	protected boolean atomElementsIncluded = false;
	protected boolean generateObjectIds = true;

	private PrintWriter printWriter;
	private int indentLevel = 0;
	private boolean xmlIndent = false;

	public Kml() {
	}

	public Kml(NetworkLinkControl networkLinkControl, Feature feature) {
		this.networkLinkControl = networkLinkControl;
		this.feature = feature;
	}

	public void setXmlIndent(boolean xmlIndent) {
		this.xmlIndent = xmlIndent;
	}

	public boolean getXmlIndent() {
		return xmlIndent;
	}

	public NetworkLinkControl getNetworkLinkControl() {
		return networkLinkControl;
	}

	public void setNetworkLinkControl(NetworkLinkControl networkLinkControl) {
		this.networkLinkControl = networkLinkControl;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public boolean isCelestialData() {
		return celestialData;
	}

	public void setCelestialData(boolean celestialData) {
		this.celestialData = celestialData;
	}

	public boolean isAtomElementsIncluded() {
		return atomElementsIncluded;
	}

	public void setAtomElementsIncluded(boolean atomElementsIncluded) {
		this.atomElementsIncluded = atomElementsIncluded;
	}

	public boolean isGenerateObjectIds() {
		return generateObjectIds;
	}

	public void setGenerateObjectIds(boolean generateObjectIds) {
		this.generateObjectIds = generateObjectIds;
	}

	public void print(String string) {
		print(string, 0);
	}

	public void println(String string) {
		println(string, 0);
	}

	public void print(String string, int indentChangeAfter) {
		printIndents();
		indentLevel += indentChangeAfter;
		printWriter.print(string);
	}

	public void println(String string, int indentChangeAfter) {
		printIndents();
		indentLevel += indentChangeAfter;
		printWriter.println(string);
	}

	public void print(int indentChangeBefore, String string) {
		indentLevel += indentChangeBefore;
		printIndents();
		printWriter.print(string);
	}

	public void println(int indentChangeBefore, String string) {
		indentLevel += indentChangeBefore;
		printIndents();
		printWriter.println(string);
	}

	private void printIndents() {
		if (xmlIndent) {
			for (int i = 0; i < indentLevel; i++) {
				printWriter.print("\t");
			}
		}
	}

	public void write(Kml kml) throws KmlException {
		kml
				.println(
						"<kml xmlns=\"http://www.opengis.net/kml/2.2\""
								+ (celestialData ? " hint=\"target=sky\"" : "")
								+ (atomElementsIncluded ? " xmlns:atom=\"http://www.w3.org/2005/Atom\""
										: "") + ">", 1);
		if (networkLinkControl != null) {
			networkLinkControl.write(kml);
		}
		if (feature != null) {
			feature.write(kml);
		}
		kml.println(-1, "</kml>");
	}

	public void createKml(OutputStream out) throws KmlException, IOException {
		this.printWriter = new PrintWriter(out);
		println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		write(this);
		this.printWriter.close();
	}

	public void createKml(PrintWriter printWriter) throws KmlException,
			IOException {
		this.printWriter = printWriter;
		println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		write(this);
		this.printWriter.close();
	}

	public static void main(String[] args) throws KmlException, IOException {

		// We create a new KML Document
		Kml kml = new Kml();

		// We create a Placemark for the Department of Informatics at the
		// university of Oslo
		Placemark ifi = new Placemark("Department of Informatics");
		ifi
				.setDescription("Web: http://www.ifi.uio.no<br/>Phone: +47 22852410");
		ifi.setLocation(10.717344, 59.943355);

		// We add a document to the kml
		Document document = new Document();
		kml.setFeature(document);

		// We add the placemark to the Document
		document.addFeature(ifi);

		try {
			// We generate the kml file
			kml.createKml(System.out);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
