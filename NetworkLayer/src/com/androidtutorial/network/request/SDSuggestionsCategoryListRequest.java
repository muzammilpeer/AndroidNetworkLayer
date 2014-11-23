/**
 * 
 */
package com.androidtutorial.network.request;

import com.androidtutorial.network.base.BaseNetworkRequest;
import com.androidtutorial.util.NetworkRequestEnum;
import com.androidtutorial.util.ReflectionUtil;
import com.google.gson.JsonObject;

/**
 * @author MuzammilPeer
 * 
 */
public class SDSuggestionsCategoryListRequest extends BaseNetworkRequest {

	public SDSuggestionsCategoryListRequest() {

	}

	public SDSuggestionsCategoryListRequest(Object model) {
		super(model);
	}

	public String getURL() throws Exception {
		return NetworkRequestEnum.BASE_REQUEST.getRelativeUrl()
				+ NetworkRequestEnum.SUBMIT_RECORD_PAYMENT.getRelativeUrl();
	}

	// for testing purpose change it to true for HTTP Method POST
	public Boolean havePostData() {
		return true;
	}

	public JsonObject postData() throws Exception {
		return getJsonObjectDataModel();
	}

	// for testing purpose change it to true for HTTP Method Get
	public Boolean haveGetData() {
		return false;
	}

	public String getData() throws Exception {
		return ReflectionUtil.getQueryStringURL(this.getURL(),
				this.getDataModel());
	}
}
