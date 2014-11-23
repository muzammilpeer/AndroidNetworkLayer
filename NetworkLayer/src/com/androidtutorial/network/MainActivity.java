package com.androidtutorial.network;

import org.json.JSONException;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.androidtutorial.network.base.BaseActivity;
import com.androidtutorial.network.base.BaseFragment;
import com.androidtutorial.network.bean.BasePaymentRequestBean;
import com.androidtutorial.network.layer.NetworkManager;
import com.androidtutorial.network.request.SDSuggestionsCategoryListRequest;
import com.androidtutorial.util.IntentEnum;
import com.androidtutorial.util.NetworkRequestEnum;
import com.systemsltd.networklayer.R;

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

		Intent i = new Intent(this, SecondActivity.class);
		startActivityForResult(i, IntentEnum.RESULT_OK.getIntentCode());

		// if (savedInstanceState == null) {
		// getSupportFragmentManager().beginTransaction()
		// .add(R.id.container, new PlaceholderFragment()).commit();
		// }
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		BasePaymentRequestBean model = data.getParcelableExtra("result");
		try {
			getList(model);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getList(BasePaymentRequestBean modelRequest)
			throws JSONException {
		SDSuggestionsCategoryListRequest req = new SDSuggestionsCategoryListRequest(
				modelRequest);
		try {
			NetworkManager.getInstance().executeRequest(req, this,
					NetworkRequestEnum.SUBMIT_RECORD_PAYMENT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
