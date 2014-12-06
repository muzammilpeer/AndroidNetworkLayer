/**
 * 
 */
package com.androidtutorial.networklayer.manager;

/**
 * @author MuzammilPeer
 *
 */

import com.androidtutorial.networklayer.protocols.ResponseProtocol;
import com.androidtutorial.networklayer.requests.BaseNetworkRequest;
import com.androidtutorial.networklayer.utils.NetworkRequestEnum;
import com.androidtutorial.restserviceexample.RestServiceExampleApplication;
import com.androidtutorial.restserviceexample.utils.MyLog;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

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
			Ion.with(RestServiceExampleApplication.getAppContext())
			.load(request.getData())
			.asJsonObject()
			.setCallback(new FutureCallback<JsonObject>() {
			   @Override
			    public void onCompleted(Exception e, JsonObject result) {
				   MyLog.e("IF exception found ", e.getMessage());
				   if (result != null)
				   {
					   respondto(delegate, result, requestType);
				   }
				   else {
					   respondto(delegate, e, requestType);
				   }
			    }
			});			
			
		} else if (request.havePostData()) {
			Ion.with(RestServiceExampleApplication.getAppContext())
			.load(request.getURL())
			.setJsonObjectBody(request.postData())
			.asJsonObject()
			.setCallback(new FutureCallback<JsonObject>() {
			   @Override
			    public void onCompleted(Exception e, JsonObject result) {
				   if (result != null)
				   {
					   respondto(delegate, result, requestType);
				   }
				   else {
					   MyLog.e("IF exception found ", e.getMessage());
					   respondto(delegate, e, requestType);
				   }
			    }
			});			
		} else if (request.haveImageData()) {
			
		} else {
			this.respondto(delegate, new Exception("No Request type defined"),
					requestType);
		}

	}


	
	//private methods
	
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