/**
 * 
 */
package com.androidtutorial.network.layer;

/**
 * @author MuzammilPeer
 *
 */

import org.json.JSONException;
import org.json.JSONObject;

import com.androidtutorial.network.NetworkLayerApplication;
import com.androidtutorial.network.base.BaseNetworkRequest;
import com.androidtutorial.util.NetworkRequestEnum;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

public class NetworkManager {
	// singleton
	protected NetworkManager() {
		// Exists only to thwart instantiation.
	}

	@SuppressWarnings("static-access")
	public static NetworkManager getInstance() {
		return (NetworkManager) SingletonRegistry.REGISTRY
				.getInstance(NetworkManager.class.getCanonicalName());
	}

	// methods

	public void executeRequest(BaseNetworkRequest request,
			final ResponseProtocol delegate, final NetworkRequestEnum requestType)
			throws Exception {

		if (null == request) {
			this.respondto(delegate, null, requestType);
		}

		// if (!internet.isAvailable()) {
		// this.respondto(delegate, new
		// Exception("Internet Not Available"),requestType);
		// return;
		// }

		if (request.haveGetData()) {
			Ion.with(NetworkLayerApplication.getAppContext())
					.load(request.getData()).asString().withResponse()
					.setCallback(new FutureCallback<Response<String>>() {
						@Override
						public void onCompleted(Exception e,
								Response<String> result) {
							if (null == result || null == result.getResult()) {
								respondto(delegate, new Exception(
										"Response is Null"), requestType);
							} else {
								JSONObject data;
								try {
									data = new JSONObject(result.getResult());
									respondto(delegate, data, requestType);
								} catch (JSONException je) {
									respondto(delegate, je, requestType);
								}
							}
						}
					});
		} else if (request.havePostData()) {
			Ion.with(NetworkLayerApplication.getAppContext())
					.load(request.getURL())
					.setJsonObjectBody(request.postData()).asString()
					.withResponse()
					.setCallback(new FutureCallback<Response<String>>() {
						@Override
						public void onCompleted(Exception e,
								Response<String> result) {
							if (null == result || null == result.getResult()) {
								respondto(delegate, new Exception(
										"Response is Null"), requestType);
							} else {
								JSONObject data;
								try {
									data = new JSONObject(result.getResult());
									respondto(delegate, data, requestType);
								} catch (JSONException je) {
									respondto(delegate, je, requestType);
								}
							}
						}
					});
		} else if (request.haveImageData()) {

		} else {
			this.respondto(delegate, new Exception("No Request type defined"),
					requestType);
		}

	}

	private void respondto(ResponseProtocol delegate, Exception error,
			NetworkRequestEnum type) {
		if (null != delegate) {
			delegate.responseWithError(error, type);
		}
	}

	private void respondto(ResponseProtocol delegate, Object data, NetworkRequestEnum type) {
		if (null != delegate) {
			delegate.successWithData(data, type);
		}
	}

}