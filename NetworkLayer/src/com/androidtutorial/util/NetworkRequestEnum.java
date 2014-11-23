/**
 * 
 */
package com.androidtutorial.util;

/**
 * @author MuzammilPeer
 * 
 * Reference from : http://javahowto.blogspot.com/2008/04/java-enum-examples.html
 */


import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;

@SuppressLint("UseSparseArrays")
public enum NetworkRequestEnum {
	
	BASE_REQUEST(0, "http://youservice.yourdomain.com/SDTF.WebAPI/", "Base server url request"),
	SUBMIT_RECORD_PAYMENT(1, "api/Service/SetPaymentDetails", "Submit payment request"),
	RECORD_PAYMENT(2, "api/Service/RecordPaymentDetails", "Record payment request")

	; // semicolon needed when fields / methods follow

	private int code;
	private String relativeUrl;
	private String description;

	/**
	 * A mapping between the integer code and its corresponding Status to
	 * facilitate lookup by code.
	 */
	private static Map<Integer, NetworkRequestEnum> codeToStatusMapping;

	private NetworkRequestEnum(int code, String relativeUrl, String description) {
		this.code = code;
		this.relativeUrl = relativeUrl;
		this.description = description;
	}

	public static NetworkRequestEnum getStatus(int i) {
		if (codeToStatusMapping == null) {
			initMapping();
		}
		return codeToStatusMapping.get(i);
	}

	@SuppressLint("UseSparseArrays")
	private static void initMapping() {
		codeToStatusMapping = new HashMap<Integer, NetworkRequestEnum>();
		for (NetworkRequestEnum s : values()) {
			codeToStatusMapping.put(s.code, s);
		}
	}

	public int getCode() {
		return code;
	}

	public String getRelativeUrl() {
		return relativeUrl;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("NetworkRequestEnum");
		sb.append("{code=").append(code);
		sb.append(", relativeUrl='").append(relativeUrl).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append('}');
		return sb.toString();
	}
}