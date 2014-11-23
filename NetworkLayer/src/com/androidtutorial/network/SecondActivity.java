/**
 * 
 */
package com.androidtutorial.network;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidtutorial.network.base.BaseActivity;
import com.androidtutorial.network.base.BaseFragment;
import com.androidtutorial.network.bean.BasePaymentRequestBean;
import com.androidtutorial.util.IntentEnum;
import com.systemsltd.networklayer.R;

/**
 * Special thanks to Hussain Mansoor for writing Objective C network layer for
 * iOS
 * 
 * @author MuzammilPeer
 * 
 */
public class SecondActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		JSONObject reqModel;
		try {
			reqModel = new JSONObject(
					"{\"referenceNo\":\"1416596689-5322\",\"RecieptNo\":\"66666666\",\"RecieptDate\":\"2014-11-21 11:11:12\",\"StatusCode\":\"0\",\"PayVCode\":\"aaa123\",\"PaymentMethod\":\"2\"}");
			BasePaymentRequestBean modelRequest = new BasePaymentRequestBean(
					reqModel);

			Intent returnIntent = new Intent(this, SecondActivity.class);
			returnIntent.putExtra("result", modelRequest);
			setResult(IntentEnum.RESULT_OK.getIntentCode(), returnIntent);
			finish();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if (savedInstanceState == null) {
		// getSupportFragmentManager().beginTransaction()
		// .add(R.id.container, new PlaceholderFragment1()).commit();
		// }
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment1 extends BaseFragment {

		public PlaceholderFragment1() {

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
