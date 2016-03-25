package downloader.detectinstalledapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import java.util.logging.Logger;

/**
 * Created by prerana_katyarmal on 3/25/2016.
 */
public class AppInstalledListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String action = intent.getAction();
        if(action.equals("android.intent.action.PACKAGE_ADDED")){
            String appNmae=getInstalledPackageInfo(context);
            Log.v("appNmae:",appNmae);
        }
        if(action.equals("android.intent.action.PACKAGE_REMOVED")){
            Log.v("DATA:",intent.getData().toString());
        }
        if(action.equals("android.intent.action.PACKAGE_REPLACED")){
            Log.v("DATA:",intent.getData().toString());
        }
    }

    private String getInstalledPackageInfo(Context context) {
        final PackageManager pm = context.getApplicationContext().getPackageManager();
        ApplicationInfo ai;
        try {
            ai = pm.getApplicationInfo(context.getPackageName(), 0);
        } catch (final PackageManager.NameNotFoundException e) {
            ai = null;
        }
        final String applicationName = (String) (ai != null ? pm.getApplicationLabel(ai) : "(unknown)");
        return applicationName;
    }
}
