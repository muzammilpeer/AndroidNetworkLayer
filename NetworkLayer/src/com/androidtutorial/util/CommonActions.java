
package com.androidtutorial.util;

import android.content.Context;

import android.view.WindowManager.BadTokenException;


public class CommonActions {

    Context currentContext;
//    MyProgressDialog myProgressDialog;

//    public CommonActions(Activity activity) {
//        // TODO Auto-generated constructor stub
//        this.currentActivity = activity;
////        myProgressDialog = new MyProgressDialog(this.currentActivity);
//    }

    public CommonActions(Context context) {
        // TODO Auto-generated constructor stub
        this.currentContext = context;
//        myProgressDialog = new MyProgressDialog(this.currentActivity);
    }

    public void showProgress() {

        try {
//            myProgressDialog = myProgressDialog.show(this.currentActivity,
//                    null, "Please wait...", true);
        } catch (BadTokenException e) {

        } catch (Exception e) {

        }
    }

    public void showProgress(String msg) {
        try {
//            myProgressDialog = myProgressDialog.show(this.currentActivity,
//                    null, msg, true);
        } catch (BadTokenException e) {

        } catch (Exception e) {

        }
    }

    public void hideProgress() {
//        if (myProgressDialog != null)
//            myProgressDialog.cancel();
//        myProgressDialog.dismiss();
    }

}
