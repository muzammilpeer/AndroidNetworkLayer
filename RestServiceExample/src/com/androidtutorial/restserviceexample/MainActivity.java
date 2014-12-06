package com.androidtutorial.restserviceexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.androidtutorial.networklayer.beans.PaymentRequestBean;
import com.androidtutorial.networklayer.beans.PaymentResponse;
import com.androidtutorial.networklayer.manager.NetworkManager;
import com.androidtutorial.networklayer.requests.SDSuggestionsCategoryListRequest;
import com.androidtutorial.networklayer.utils.NetworkRequestEnum;
import com.androidtutorial.networklayer.utils.NetworkUtil;
import com.androidtutorial.restserviceexample.activities.BaseActivity;
import com.androidtutorial.restserviceexample.fragments.BaseFragment;
import com.androidtutorial.restserviceexample.utils.MyLog;

/**
 * Special thanks to Hussain Mansoor for writing Objective C network layer for
 * iOS
 * 
 * @author MuzammilPeer
 * 
 */

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
		PaymentRequestBean reqModel = new PaymentRequestBean();
		reqModel.setReferenceNo("1416596689-5322");
		reqModel.setRecieptNo("66666666");
		reqModel.setRecieptDate("2014-11-21 11:11:12");
		reqModel.setStatusCode("0");
		reqModel.setPayVCode("aaa123");
		reqModel.setPaymentMethod("2");
		
		
		getList(reqModel);
		
	}
	
	@Override
	public void successWithData(Object data, NetworkRequestEnum requestType) {
		super.successWithData(data, requestType);
		PaymentResponse obj = (PaymentResponse) NetworkUtil.getObjectFromJsonObject(data,PaymentResponse.class);
		MyLog.e("Data Fetched ", obj.getMessage());
	}


	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	}

	private void getList(PaymentRequestBean modelRequest) {
		SDSuggestionsCategoryListRequest req = new SDSuggestionsCategoryListRequest(
				modelRequest);
		
		try {
			NetworkManager.getInstance().executeRequest(req, this,
					NetworkRequestEnum.SUBMIT_RECORD_PAYMENT);
		} catch (Exception e) {
			MyLog.e("Request Error ", e.getCause().toString());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends BaseFragment {

		public PlaceholderFragment() {

		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);

			// setup the screen data
			initObjects();
			initViews();

			return rootView;
		}

		public void initObjects() {
			super.initObjects();
		}

		public void initViews() {
			super.initViews();
		}

	}

}
