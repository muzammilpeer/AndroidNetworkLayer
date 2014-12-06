package com.androidtutorial.networklayer.beans;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.os.Parcel;
import android.os.Parcelable;

import com.androidtutorial.restserviceexample.utils.MyLog;
import com.androidtutorial.restserviceexample.utils.ReflectionUtil;
/**
 * @author MuzammilPeer
 * 
 */

public class BaseBean implements Parcelable {

	@Override
	public String toString() {
		return ReflectionUtil.getToStringDescription(getClass(), this);
	}

	// constructor
	public BaseBean() {

	}

	protected BaseBean(Parcel in) {
		for (Method method : ReflectionUtil.findGettersSetters(getClass(), false)) {
			try {

				String returnValue = (String) method.invoke(this,
						in.readString());
				if (returnValue != null) {
					MyLog.e(method.getName(), returnValue);
				}
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				MyLog.e("error occured", e.getMessage());
			}

		}
		MyLog.e("Parcel Bean In completed", "End");
	}

	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// dest.writeString(statusCode);
		for (Method method : ReflectionUtil.findGettersSetters(getClass(), true)) {
			try {
				String returnValue = (String) method.invoke(this, null);
				if (returnValue != null) {
					MyLog.e(method.getName(), returnValue);
					dest.writeString(returnValue);
				}
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				MyLog.e("error occured", e.getMessage());
			}

		}
		MyLog.e("writeToParcel is completed", "End");
	}

	public static final Parcelable.Creator<BaseBean> CREATOR = new Parcelable.Creator<BaseBean>() {
		@Override
		public BaseBean createFromParcel(Parcel in) {
			return new BaseBean(in);
		}

		@Override
		public BaseBean[] newArray(int size) {
			return new BaseBean[size];
		}
	};


}
