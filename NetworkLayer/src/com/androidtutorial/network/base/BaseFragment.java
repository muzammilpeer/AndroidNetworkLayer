package com.androidtutorial.network.base;

import android.support.v4.app.Fragment;

import com.androidtutorial.network.NetworkLayerApplication;
import com.androidtutorial.network.layer.ResponseProtocol;
import com.androidtutorial.util.CommonActions;
import com.androidtutorial.util.MyLog;
import com.androidtutorial.util.NetworkRequestEnum;

public class BaseFragment extends Fragment implements ResponseProtocol{

	public CommonActions ca;
	
	public BaseFragment() {
		
		initObjects();
		initViews();
	}
	
	public void initObjects()
	{
		ca = new CommonActions(NetworkLayerApplication.getAppContext());
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
