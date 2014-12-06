package com.androidtutorial.networklayer.beans;

import org.json.JSONObject;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * @author MuzammilPeer
 * 
 */


public class PaymentRequestBean extends BaseBean {

	@SerializedName("PayVCode")
	private String payVCode;
	
	@SerializedName("referenceNo")
	private String referenceNo;

	@SerializedName("RecieptNo")
	private String recieptNo;
	
	@SerializedName("RecieptDate")
	private String recieptDate;
	
	@SerializedName("PaymentMethod")
	private String paymentMethod;
	
	@SerializedName("StatusCode")
	private String statusCode;

	public PaymentRequestBean() {

	}

	public PaymentRequestBean(JSONObject json) {

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
	protected PaymentRequestBean(Parcel in) {
		super(in);
	}

	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		super.writeToParcel(dest, flags);
	}

	public static final Parcelable.Creator<PaymentRequestBean> CREATOR = new Parcelable.Creator<PaymentRequestBean>() {
		@Override
		public PaymentRequestBean createFromParcel(Parcel in) {
			return new PaymentRequestBean(in);
		}

		@Override
		public PaymentRequestBean[] newArray(int size) {
			return new PaymentRequestBean[size];
		}
	};
	
}