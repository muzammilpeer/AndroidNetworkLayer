/**
 * 
 */
package com.androidtutorial.restserviceexample;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/**
 * Special thanks to Hussain Mansoor for writing Objective C network layer for
 * iOS
 * 
 * @author MuzammilPeer
 * 
 */

public class RestServiceExampleApplication extends Application {

	private static RestServiceExampleApplication sInstance;

	@Override
	public void onCreate() {
		super.onCreate();
		sInstance = this;
	}

	public static Context getAppContext() {
		return sInstance.getApplicationContext();
	}

	public static RestServiceExampleApplication getInstance() {
		return sInstance;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

}
