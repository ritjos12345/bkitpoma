package com.poma.bkitpoma.client;

import com.google.gwt.user.client.rpc.*;
import java.util.*;

public class Tracked implements IsSerializable {
	/**
	 * HashMap that will always contain strings for both keys and values
	 */
	private HashMap<String, String> trackedInfo = null;

	/**
	 * Default Constructor
	 */
	public Tracked() {
		trackedInfo = new HashMap<String, String>();
		
		trackedInfo.put("username", "");
		trackedInfo.put("apikey", "");
		trackedInfo.put("name", "");
		trackedInfo.put("birthday", "");
		trackedInfo.put("tel", "");
		trackedInfo.put("email", "");
		trackedInfo.put("state", "");
		trackedInfo.put("gpsState","");
		trackedInfo.put("gmt", "");
		trackedInfo.put("lang", "");
		trackedInfo.put("country","");
		trackedInfo.put("iconPath","");
		trackedInfo.put("showinmap","");
		trackedInfo.put("embedded", "");
	}
	
	public Tracked(String username,String apikey,String name,String birthday,String tel,String email,String state,String gpsState,String iconPath,String showInMap,String eb){
		trackedInfo.put("username", username);
		trackedInfo.put("apikey", apikey);
		trackedInfo.put("name", name);
		trackedInfo.put("birthday", birthday);
		trackedInfo.put("tel", tel);
		trackedInfo.put("email", email);
		trackedInfo.put("state", state);
		trackedInfo.put("gpsState",gpsState);
		trackedInfo.put("iconPath", iconPath);
		trackedInfo.put("showinmap",showInMap);
		trackedInfo.put("embedded", eb);
	}

	/**
	 * Method used to set the contact's name
	 * 
	 * @param name
	 *            contact's name
	 */
	public void setUsername(String name) {
		trackedInfo.put("username", name);
	}

	public void setAPIKey(String name) {
		trackedInfo.put("apikey", name);
	}
	
	public void setName(String name) {
		trackedInfo.put("name", name);
	}
	
	public void setBirthday(String name) {
		trackedInfo.put("birthday", name);
	}

	public void setTel(String name) {
		trackedInfo.put("tel", name);
	}

	public void setEmail(String name) {
		trackedInfo.put("email", name);
	}

	public void setState(String name) {
		trackedInfo.put("state", name);
	}
	
	public void setGpsState(String name) {
		trackedInfo.put("gpsState", name);
	}
	
	public void setGMT(String gmt){
		trackedInfo.put("gmt", gmt);
	}
	
	public void setLang(String lang){
		trackedInfo.put("lang",lang);
	}
	
	public void setCountry(String country){
		trackedInfo.put("country", country);
	}
	
	public void setIconPath(String iconPath){
		trackedInfo.put("iconPath", iconPath);
	}
	
	public void setShowInMap(String showInMap){
		trackedInfo.put("showinmap", showInMap);
	}
	
	public void setEmbedded(String embedded){
		trackedInfo.put("embedded", embedded);
	}
	
	public String getEmbedded(){
		return (String)trackedInfo.get("embedded");
	}
	
	public String getShowInMap(){
		return (String)trackedInfo.get("showinmap");
	}
	
	public String getIconPath(){
		return (String) trackedInfo.get("iconPath");
	}
	
	public String getUsername() {
		return (String) trackedInfo.get("username");
	}

	public String getAPIKey() {
		return (String) trackedInfo.get("apikey");
	}
	
	public String getName() {
		return (String) trackedInfo.get("name");
	}
	
	public String getBirthday() {
		return (String) trackedInfo.get("birthday");
	}

	public String getTel() {
		return (String) trackedInfo.get("tel");
	}

	public String getEmail() {
		return (String) trackedInfo.get("email");
	}

	public String getState() {
		return (String) trackedInfo.get("state");
	}
	
	public String getGpsState() {
		return (String) trackedInfo.get("gpsState");
	}
	
	public String getGMT(){
		return (String)trackedInfo.get("gmt");
	}
	
	public String getLang(){
		return (String)trackedInfo.get("lang");
	}
	
	public String getCountry(){
		return (String)trackedInfo.get("country");
	}

}// end class Contact