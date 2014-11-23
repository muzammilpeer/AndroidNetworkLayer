/**
 * 
 */
package com.androidtutorial.util;

/**
 * @author MuzammilPeer
 * 
 */

public enum IntentEnum {
	RESULT_OK (100),
	RESULT_CANCEL(101)
	; // semicolon needed when fields / methods follow

	private final int intentCode;

	IntentEnum(int intentCode) {
		this.intentCode = intentCode;
	}

	public int getIntentCode() {
		return this.intentCode;
	}
}
