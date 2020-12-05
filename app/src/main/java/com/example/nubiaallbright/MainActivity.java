package com.example.nubiaallbright;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

public class MainActivity extends AppCompatActivity {

    private PowerManager.WakeLock mWakeLock;

    @SuppressLint("InvalidWakeLockTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "keep_screen_on_tag");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWakeLock.acquire();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mWakeLock.release();
    }
}