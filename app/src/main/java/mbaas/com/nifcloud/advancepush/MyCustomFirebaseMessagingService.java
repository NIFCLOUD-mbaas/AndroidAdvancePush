package mbaas.com.nifcloud.advancepush;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.nifcloud.mbaas.core.NCMBFirebaseMessagingService;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MyCustomFirebaseMessagingService extends NCMBFirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    private static final int REQUEST_RESULT = 0;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //**************** 【mBaaS：プッシュ通知⑦】プッシュ通知からデータを取得する***************
        //******** 【mBaaS：Push Notification⑦】App Obtains Data from Push Notification********


        //デフォルトの通知
        super.onMessageReceived(remoteMessage);
    }



}
