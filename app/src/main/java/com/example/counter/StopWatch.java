package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class StopWatch extends AppCompatActivity {

    private boolean running;
    private Chronometer chronometer;
    private long pauseOffset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemClock.sleep(2000); //add this line to increase duration of splash screen
        setContentView(R.layout.activity_stop_watch);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(chronometer -> {

            if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                Toast.makeText(StopWatch.this, "Bing!", Toast.LENGTH_SHORT).show();

            }

        });
    }

    public void startchronometer(View view) {

        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pausechronometer(View view) {

        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void resetchronometer(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
}
