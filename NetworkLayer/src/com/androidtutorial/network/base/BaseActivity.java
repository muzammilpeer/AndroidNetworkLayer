/**
 * 
 */
package com.androidtutorial.network.base;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.androidtutorial.network.NetworkLayerApplication;
import com.androidtutorial.network.layer.ResponseProtocol;
import com.androidtutorial.util.CommonActions;
import com.androidtutorial.util.MyLog;
import com.androidtutorial.util.NetworkRequestEnum;

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
		ca = new CommonActions(NetworkLayerApplication.getAppContext());
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
