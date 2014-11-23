/**
 * 
 */
package com.androidtutorial.network.layer;

import com.androidtutorial.util.NetworkRequestEnum;

/**
 * Initially written by Hussain Mansoor for Objective C
 * @author MuzammilPeer
 *
 */
public interface ResponseProtocol {
	public void responseWithError(Exception error,NetworkRequestEnum requestType);
	public void successWithData(Object data,NetworkRequestEnum requestType);
}
