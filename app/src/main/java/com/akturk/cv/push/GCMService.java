package com.akturk.cv.push;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.akturk.cv.R;
import com.kinvey.android.push.KinveyGCMService;

public class GCMService extends KinveyGCMService {

    private static final int NOTIFICATION_ID = 567;

    @Override
    public void onMessage(String message) {
        displayNotification(message);
    }

    @Override
    public void onError(String error) {
    }

    @Override
    public void onDelete(String deleted) {
    }

    @Override
    public void onRegistered(String gcmID) {
    }

    @Override
    public void onUnregistered(String oldID) {
    }

    public Class getReceiver() {
        return GCMReceiver.class;
    }

    private void displayNotification(String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(
                        getApplicationContext()
                                .getResources()
                                .getString(R.string.app_name))
                .setContentText(message);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(NOTIFICATION_ID, builder.build());
        }
    }
}