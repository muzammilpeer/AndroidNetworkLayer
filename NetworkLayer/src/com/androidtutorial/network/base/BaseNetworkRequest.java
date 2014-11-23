/**
 * 
 */
package com.androidtutorial.network.base;

import java.util.Map;

import com.androidtutorial.network.layer.RequestProtocol;
import com.androidtutorial.util.NetworkUtil;
import com.androidtutorial.util.ReflectionUtil;
import com.google.gson.JsonObject;

/**
 * @author MuzammilPeer
 *
 */
public class BaseNetworkRequest implements RequestProtocol {
	
	//Data model property
	private Object dataModel = null;
	public Object getDataModel() {
		return dataModel;
	}
	public void setDataModel(Object dataModel) {
		this.dataModel = dataModel;
	}

	//Constructors
	
	public BaseNetworkRequest() {
		//do any thing
	}
	
	//copy constructor
	public BaseNetworkRequest(Object model) {
		
		//passing data model to object level variables
		this.setDataModel(model);
	}

	@Override
	public String getURL() throws Exception  {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = ReflectionUtil.getClassName(getClass());
		throw new Exception("You must override method "+ methodName +" in "+ className);
	}

	@Override
	public Boolean haveGetData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getData() throws Exception {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = ReflectionUtil.getClassName(getClass());
		throw new Exception("You must override method "+ methodName +" in "+ className);
	}

	@Override
	public Boolean havePostData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JsonObject postData() throws Exception {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = ReflectionUtil.getClassName(getClass());
		throw new Exception("You must override method "+ methodName +" in "+ className);
	}

	@Override
	public Boolean haveImageData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getImageData() throws Exception {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = ReflectionUtil.getClassName(getClass());
		throw new Exception("You must override method "+ methodName +" in "+ className);
	}

	
	//utility methods
	public JsonObject getJsonObjectDataModel()
	{
		return NetworkUtil.getJsonObjectFromObject(this.getDataModel());
	}
	


}
