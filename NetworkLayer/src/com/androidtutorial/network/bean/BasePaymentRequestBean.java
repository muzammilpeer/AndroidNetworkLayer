package com.androidtutorial.network.bean;

import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

import com.androidtutorial.network.base.BaseBean;
/**
 * @author MuzammilPeer
 * 
 */


public class BasePaymentRequestBean extends BaseBean {

	private String payVCode;
	private String referenceNo;
	private String recieptNo;
	private String recieptDate;
	private String paymentMethod;
	private String statusCode;

	public BasePaymentRequestBean() {

	}

	public BasePaymentRequestBean(JSONObject json) {

		this.payVCode = json.optString("PayVCode");
		this.referenceNo = json.optString("referenceNo");
		this.recieptNo = json.optString("RecieptNo");
		this.recieptDate = json.optString("RecieptDate");
		this.paymentMethod = json.optString("PaymentMethod");
		this.statusCode = json.optString("StatusCode");

	}

	public String getPayVCode() {
		return this.payVCode;
	}

	public void setPayVCode(String payVCode) {
		this.payVCode = payVCode;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getRecieptNo() {
		return this.recieptNo;
	}

	public void setRecieptNo(String recieptNo) {
		this.recieptNo = recieptNo;
	}

	public String getRecieptDate() {
		return this.recieptDate;
	}

	public void setRecieptDate(String recieptDate) {
		this.recieptDate = recieptDate;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	// Make my bean parcellable using reflection to reduce line of code
	protected BasePaymentRequestBean(Parcel in) {
		super(in);
	}

	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		super.writeToParcel(dest, flags);
	}

	public static final Parcelable.Creator<BasePaymentRequestBean> CREATOR = new Parcelable.Creator<BasePaymentRequestBean>() {
		@Override
		public BasePaymentRequestBean createFromParcel(Parcel in) {
			return new BasePaymentRequestBean(in);
		}

		@Override
		public BasePaymentRequestBean[] newArray(int size) {
			return new BasePaymentRequestBean[size];
		}
	};
}