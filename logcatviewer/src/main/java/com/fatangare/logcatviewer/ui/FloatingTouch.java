package com.fatangare.logcatviewer.ui;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;

import com.fatangare.logcatviewer.R;
import com.hjq.xtoast.OnClickListener;
import com.hjq.xtoast.XToast;
import com.hjq.xtoast.draggable.SpringDraggable;
import com.fatangare.logcatviewer.utils.LogcatViewer;


/**
 * Floating touch window to call out LogcatViewer on top.
 */
final class FloatingTouch extends XToast implements OnClickListener {
    private Activity activity;
    private long lastClickTime;

    FloatingTouch(Activity activity) {
        super(activity);
        this.activity = activity;
        setView(R.layout.window_floating);
        setAnimStyle(android.R.style.Animation_Toast);
        setDraggable(new SpringDraggable());
        setGravity(Gravity.END | Gravity.CENTER_VERTICAL);
        setOnClickListener(android.R.id.icon, this);
    }

    @Override
    public void onClick(XToast toast, View view) {
        if(lastClickTime +250 > System.currentTimeMillis()) {
            LogcatViewer.showLogcatLoggerView(this.activity);
        }
        lastClickTime =System.currentTimeMillis();
    }
}