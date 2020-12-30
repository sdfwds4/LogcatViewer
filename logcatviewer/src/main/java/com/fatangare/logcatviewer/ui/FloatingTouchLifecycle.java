package com.fatangare.logcatviewer.ui;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Lifecycle to control floating touch window.
 */
public final class FloatingTouchLifecycle implements Application.ActivityLifecycleCallbacks {

    public static void with(Application application) {
        application.registerActivityLifecycleCallbacks(new FloatingTouchLifecycle());
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//        if (activity instanceof LogcatActivity) {
//            return;
//        }
        new FloatingTouch(activity)
                .show();
    }

    @Override
    public void onActivityStarted(Activity activity) {}

    @Override
    public void onActivityResumed(Activity activity) {}

    @Override
    public void onActivityPaused(Activity activity) {}

    @Override
    public void onActivityStopped(Activity activity) {}

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}

    @Override
    public void onActivityDestroyed(Activity activity) {}
}