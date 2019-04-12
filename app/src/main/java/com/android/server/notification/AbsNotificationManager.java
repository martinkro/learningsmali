package com.android.server.notification;

import android.app.Notification;
import android.os.UserHandle;

public abstract class AbsNotificationManager {

    public void recognize(String tag,
                                   int id,
                                   Notification notification,
                                   UserHandle user,
                                   String pkg,
                                   int uid,
                                   int pid
    ){

    }
}
