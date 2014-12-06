package com.androidtutorial.networklayer.beans;

import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
public class PaymentResponse implements Parcelable {
	
	@SerializedName("Message")
	private String message;
	
	@SerializedName("transactionNo")
    private String transactionNo;

	@SerializedName("Status")
	private double status;
    
    
	public PaymentResponse () {
		
	}	
        
    public PaymentResponse (JSONObject json) {
    
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
    protected PaymentResponse(Parcel in) {
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

    public static final Parcelable.Creator<PaymentResponse> CREATOR = new Parcelable.Creator<PaymentResponse>() {
        @Override
        public PaymentResponse createFromParcel(Parcel in) {
            return new PaymentResponse(in);
        }

        @Override
        public PaymentResponse[] newArray(int size) {
            return new PaymentResponse[size];
        }
    };
}