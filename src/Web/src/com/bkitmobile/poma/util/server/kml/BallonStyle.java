package com.bkitmobile.poma.util.server.kml;

public class BallonStyle extends KmlObject {

	private String bgColor;
	private String textColor;
	private String text;
	private DisplayModeEnum displayMode;
	
	public BallonStyle() {}
	
	public BallonStyle(String bgColor, String textColor, String text, DisplayModeEnum displayMode) {
		this.bgColor = bgColor;
		this.textColor = textColor;
		this.text = text;
		this.displayMode = displayMode;
	}
	
	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public DisplayModeEnum getDisplayMode() {
		return displayMode;
	}

	public void setDisplayMode(DisplayModeEnum displayMode) {
		this.displayMode = displayMode;
	}

	public void write(Kml kml) throws KmlException {
		kml.println("<BallonStyle" + getIdAndTargetIdFormatted(kml) + ">", 1);
		if (bgColor != null) {
			kml.println("<bgColor>" + bgColor + "</bgColor>");
		}
		if (textColor != null) {
			kml.println("<textColor>" + textColor + "</textColor>");
		}
		if (text != null) {
			kml.println("<text>" + text + "</text>");
		}
		if (displayMode != null) {
			kml.println("<displayMode>" + (displayMode == DisplayModeEnum._default ? "default" : displayMode) + "</displayMode>");
		}
		kml.println(-1, "</BallonStyle>");
	}
	
	public void writeDelete(Kml kml) throws KmlException {
		kml.println("<BallonStyle" + getIdAndTargetIdFormatted(kml) + "></>");
	}
}