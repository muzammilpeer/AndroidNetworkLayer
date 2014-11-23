/**
 * 
 */
package com.androidtutorial.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author MuzammilPeer
 *
 */
public class NetworkUtil {

	//shared method for json coversion
	public  static JsonObject getJsonObjectFromObject(final Object obj) {

		Gson gson = new Gson();
		String modelString = gson.toJson(obj);
		JsonParser parser = new JsonParser();
		JsonObject model = (JsonObject)parser.parse(modelString);
		
		return model;
	}
	



}
