package com.androidtutorial.restserviceexample.fragments;

import android.support.v4.app.Fragment;

import com.androidtutorial.networklayer.protocols.ResponseProtocol;
import com.androidtutorial.networklayer.utils.NetworkRequestEnum;
import com.androidtutorial.restserviceexample.RestServiceExampleApplication;
import com.androidtutorial.restserviceexample.utils.CommonActions;
import com.androidtutorial.restserviceexample.utils.MyLog;

public class BaseFragment extends Fragment implements ResponseProtocol{

	public CommonActions ca;
	
	public BaseFragment() {
		
		initObjects();
		initViews();
	}
	
	public void initObjects()
	{
		ca = new CommonActions(RestServiceExampleApplication.getAppContext());
	}
	
	public void initViews()
	{
		
	}
	
	
	//Response Protocol Delegates
	
	@Override
	public void responseWithError(Exception error, NetworkRequestEnum requestType) {
		ca.hideProgress();
		MyLog.e("Error Recieved in Delegate ", "Check it");
	}

	@Override
	public void successWithData(Object data, NetworkRequestEnum requestType) {
		ca.hideProgress();
		MyLog.e("Data Recieved in Delegate ", "Check it");
	}
}
