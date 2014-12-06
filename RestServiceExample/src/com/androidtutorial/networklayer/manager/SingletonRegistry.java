/**
 * 
 */
package com.androidtutorial.networklayer.manager;

import java.util.HashMap;

import com.androidtutorial.restserviceexample.utils.MyLog;

/**
 * @author MuzammilPeer
 * 
 */
public class SingletonRegistry {
	public static SingletonRegistry REGISTRY = new SingletonRegistry();
	@SuppressWarnings("rawtypes")
	private static HashMap map = new HashMap();

	// private static Logger logger = Logger.getRootLogger();
	protected SingletonRegistry() {
		// Exists to defeat instantiat ion
	}

	@SuppressWarnings("unchecked")
	public static synchronized Object getInstance(String classname) {
		Object singleton = map.get(classname);
		if (singleton != null) {
			return singleton;
		}
		try {
			singleton = Class.forName(classname).newInstance();
			MyLog.e("created singleton: ", singleton.toString());
		} catch (ClassNotFoundException cnf) {
			MyLog.e("Couldn't find class: ", classname);
		} catch (InstantiationException ie) {
			MyLog.e("Couldn't instantiate an object of type ", classname);
		} catch (IllegalAccessException ia) {
			MyLog.e("Couldn't access class ", classname);
		}
		map.put(classname, singleton);
		return singleton;
	}
}