/**
 * 
 */
package com.androidtutorial.network.layer;

import com.google.gson.JsonObject;


/**
 * @author MuzammilPeer
 *
 */
public interface RequestProtocol {
//	- (NSString *) url;
//
//	- (BOOL) haveGetData;
//	- (NSDictionary *) getData;
//
//	- (BOOL) havePostData;
//	- (NSData *) postData;
	
	public  String getURL() throws Exception;
	public Boolean haveGetData();
	public String getData() throws Exception;
	public Boolean havePostData();
	public JsonObject postData() throws Exception;
	public Boolean haveImageData();
	public Object getImageData() throws Exception;
}
