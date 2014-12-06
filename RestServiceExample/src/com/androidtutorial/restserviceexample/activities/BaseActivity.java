/**
 * 
 */
package com.androidtutorial.restserviceexample.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.androidtutorial.networklayer.beans.PaymentResponse;
import com.androidtutorial.networklayer.protocols.ResponseProtocol;
import com.androidtutorial.networklayer.utils.NetworkRequestEnum;
import com.androidtutorial.networklayer.utils.NetworkUtil;
import com.androidtutorial.restserviceexample.RestServiceExampleApplication;
import com.androidtutorial.restserviceexample.utils.CommonActions;
import com.androidtutorial.restserviceexample.utils.MyLog;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * @author MuzammilPeer
 * 
 */
public class BaseActivity extends ActionBarActivity implements ResponseProtocol {

	public CommonActions ca;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initObjects();
		initViews();
	}

	public void initObjects() {
		ca = new CommonActions(RestServiceExampleApplication.getAppContext());
	}

	public void initViews() {

	}

	// Response Protocol Delegates

	@Override
	public void responseWithError(Exception error, NetworkRequestEnum requestType) {
		ca.hideProgress();
		MyLog.e("Webservice error",error == null || error.getMessage() == null ? "Exception" : error.getMessage() + "Data fetched for Request URL = "+requestType.getRelativeUrl());
	}

	@Override
	public void successWithData(Object data, NetworkRequestEnum requestType) {
		ca.hideProgress();
		
		MyLog.e("Webservice success","Data fetched for Request URL = "+requestType.getRelativeUrl());
	}

}
