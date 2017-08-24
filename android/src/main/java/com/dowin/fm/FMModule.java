package com.dowin.fm;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import cn.tongdun.android.shell.FMAgent;

/**
 * Created by dowin on 2016/12/2.
 */

public class FMModule extends ReactContextBaseJavaModule {

    public static final String RCT_CLASS = "FMDevice";
    public static final String TAG = "FMDevice";

    private Context context;

    public FMModule(ReactApplicationContext reactContext) {
        super(reactContext);
        context = reactContext.getBaseContext();
    }

    @Override
    public String getName() {
        return RCT_CLASS;
    }

    @ReactMethod
    public void registerFMDevicesresolve(){

        Log.i(TAG,"registerFMDevicesresolve");
        //初始化同盾风控SDK集成
        FMAgent.openLog();
        FMAgent.init(context.getApplicationContext(),FMAgent.ENV_SANDBOX);
    }

    @ReactMethod
    public void getFMDevicesresolve(Callback callback){
        Log.i(TAG,"getFMDevicesresolve");
        String backBox  = FMAgent.onEvent(context);
        callback.invoke(backBox);
    }
}
