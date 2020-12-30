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

package com.fatangare.logcatviewer.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

import com.fatangare.logcatviewer.utils.LogcatViewer;

public class MainActivity extends AppCompatActivity {

    private AtomicBoolean mStart = new AtomicBoolean();

    private Runnable mTestLog = new Runnable() {
        @Override
        public void run() {
            while (mStart.get()) {
                Log.d("Test", String.valueOf(System.currentTimeMillis()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStart.set(true);
        new Thread(mTestLog).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStart.set(false);
    }
}
