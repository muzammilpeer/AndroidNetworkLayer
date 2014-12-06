/**
 * 
 */
package com.androidtutorial.networklayer.requests;

import com.androidtutorial.networklayer.utils.NetworkRequestEnum;
import com.androidtutorial.restserviceexample.utils.ReflectionUtil;
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
		return  super.getJsonObjectDataModel();
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
