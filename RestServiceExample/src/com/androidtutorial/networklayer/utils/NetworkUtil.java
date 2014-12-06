/**
 * 
 */
package com.androidtutorial.networklayer.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author MuzammilPeer
 * 
 */
public class NetworkUtil {

	// shared method for json coversion
	public static JsonObject getJsonObjectFromObject(final Object obj) {

		Gson gson = new Gson();
		String modelString = gson.toJson(obj);
		JsonParser parser = new JsonParser();
		JsonObject model = (JsonObject) parser.parse(modelString);

		return model;
	}

	public static <T> Object getObjectFromJsonObject(final Object data,Class<T> classofT) {

		if (data instanceof JsonObject) {
			JsonObject json = (JsonObject) data;
			Gson gson = new Gson();
			T obj = gson.fromJson(json, classofT);
			return obj;
		}
		return null;
	}

}
