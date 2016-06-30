package com.xiaoming.giftspeak.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaoming.giftspeak.MainActivity;
import com.xiaoming.giftspeak.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        skipWelcomeActivity();
    }

    private void skipWelcomeActivity() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();;
            }
        },1500);
    }
}
