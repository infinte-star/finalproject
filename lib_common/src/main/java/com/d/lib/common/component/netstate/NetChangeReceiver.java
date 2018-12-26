package com.d.lib.common.component.netstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/**
 * NetChangeReceiver
 */
public class NetChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return;
        }
        NetCompat.reset(context);
    }
}
