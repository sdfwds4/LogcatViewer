/**
 * Copyright (C) 2016  Sandeep Fatangare <sandeep@fatangare.info>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.fatangare.logcatviewer.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.fatangare.logcatviewer.service.LogcatViewerFloatingView;

import wei.mark.standout.StandOutWindow;
import wei.mark.standout.Utils;

/**
 * This class will launch {@link LogcatViewerFloatingView} view.
 */
public class LogcatViewer {
    static final String TAG = "Permissions";

    /**
     * Launch {@link LogcatViewerFloatingView} view.
     * @param context context.
     */
    public static void showLogcatLoggerView(Context context){
        StandOutWindow.closeAll(context, LogcatViewerFloatingView.class);
        StandOutWindow
                .show(context, LogcatViewerFloatingView.class, StandOutWindow.DEFAULT_ID);
    }

    /**
     * Close  {@link LogcatViewerFloatingView} view.
     *
     * @param context context.
     */
    public static void closeLogcatLoggerView(Context context) {
        StandOutWindow.closeAll(context, LogcatViewerFloatingView.class);
    }

    public static void showLogcatLoggerViewWith(@NonNull final FragmentActivity activity) {
        if (Utils.canDrawOverlays(activity)) {
            showLogcatLoggerView(activity);
        } else {
            setupFragment(activity.getSupportFragmentManager());
        }
    }

    public static void showLogcatLoggerViewWith(@NonNull final Fragment fragment) {
        if (Utils.canDrawOverlays(fragment.getContext())) {
            showLogcatLoggerView(fragment.getContext());
        } else {
            setupFragment(fragment.getChildFragmentManager());
        }
    }

    private static void setupFragment(@NonNull final FragmentManager fragmentManager) {
        PermissionsFragment fragment = (PermissionsFragment) fragmentManager.findFragmentByTag(TAG);
        boolean isNewInstance = fragment == null;
        if (isNewInstance) {
            fragment = new PermissionsFragment();
            fragmentManager
                .beginTransaction()
                .add(fragment, TAG)
                .commitNow();
        }

        fragment.getPermission();
    }

    public static class PermissionsFragment extends Fragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRetainInstance(true);
        }

        public void getPermission() {
            Context context = getContext();
            if (null == context) {
                return;
            }
            startActivityForResult(Utils.getActionManageOverlayPermission(context), 1);
        }

        @Override
        public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (Utils.canDrawOverlays(getContext())) {
                LogcatViewer.showLogcatLoggerView(getContext());
            }
        }
    }
}
