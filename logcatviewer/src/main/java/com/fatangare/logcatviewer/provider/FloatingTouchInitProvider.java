package com.fatangare.logcatviewer.provider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;

import com.fatangare.logcatviewer.ui.FloatingTouchLifecycle;

/**
 * Provider to show floating touch window.
 */
public final class FloatingTouchInitProvider extends ContentProvider {

    @Override
    public boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            if (context instanceof Application) {
                FloatingTouchLifecycle.with((Application) context);
            } else {
                Toast.makeText(context, "参数错误，无法启动 Logcat", Toast.LENGTH_LONG).show();
            }
        }
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}