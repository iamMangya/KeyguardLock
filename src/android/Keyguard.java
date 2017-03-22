package com.lotus.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.util.Log;
import android.provider.Settings;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import android.app.KeyguardManager;
import android.app.ActivityManager;
import android.app.Activity;
import android.content.Context;
public class Keyguard extends CordovaPlugin {

    @Override
    public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
	Context context=this.cordova.getActivity().getApplicationContext();
	ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
	KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);


	//KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Activity.KEYGUARD_SERVICE);
    boolean deviceLockStatus = keyguardManager.isKeyguardSecure();
        if(deviceLockStatus)
        {
            callbackContext.success("Hello true");
        }
        else
        {
            callbackContext.success("Hello false");
        }


        return true;
    }

}

