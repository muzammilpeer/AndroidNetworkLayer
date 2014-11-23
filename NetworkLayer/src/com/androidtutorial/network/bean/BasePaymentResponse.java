package com.androidtutorial.network.bean;

import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;
public class BasePaymentResponse implements Parcelable {
	
    private String message;
    private String transactionNo;
    private double status;
    
    
	public BasePaymentResponse () {
		
	}	
        
    public BasePaymentResponse (JSONObject json) {
    
        this.message = json.optString("Message");
        this.transactionNo = json.optString("transactionNo");
        this.status = json.optDouble("Status");

    }
    
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransactionNo() {
        return this.transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public double getStatus() {
        return this.status;
    }

    public void setStatus(double status) {
        this.status = status;
    }
    protected BasePaymentResponse(Parcel in) {
        message = in.readString();
        transactionNo = in.readString();
        status = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(transactionNo);
        dest.writeDouble(status);
    }

    public static final Parcelable.Creator<BasePaymentResponse> CREATOR = new Parcelable.Creator<BasePaymentResponse>() {
        @Override
        public BasePaymentResponse createFromParcel(Parcel in) {
            return new BasePaymentResponse(in);
        }

        @Override
        public BasePaymentResponse[] newArray(int size) {
            return new BasePaymentResponse[size];
        }
    };
}