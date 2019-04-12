package com.android.server.notification;

import android.app.Notification;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Log;

import java.util.List;

public class HwNotificationManagerService extends NotificationManagerService {

    private static final String TAG = HwNotificationManagerService.class.getSimpleName();
    private List<String> mBtwList;
    private final ArrayMap<String,String> mRecognizeMap = new ArrayMap<String,String>();

    private boolean mIsChina = true;
    public void recognize(String tag,
                                   int id,
                                   Notification notification,
                                   UserHandle user,
                                   String pkg,
                                   int uid,
                                   int pid
    ){
        if (!mIsChina){
            Log.d(TAG,"recognize: not in china");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pkg);
        sb.append(pid);

        String key = sb.toString();
        synchronized (mRecognizeMap){
            String value = mRecognizeMap.get(key);
            if (value.equals("0")){
                return;
            }
        }

        synchronized (mRecognizeMap){
            mRecognizeMap.put(sb.toString(),"0");
        }

    }
}
