package com.kumardsingh.gaya.fragmentcycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Deepak Activity","On Create");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Deepak Activity","On Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Deepak Activity","On Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Deepak Activity","On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Deepak Activity","On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Deepak Activity","On Destroy");
    }
}