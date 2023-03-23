package com.kumardsingh.gaya.cameraexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Deepak DescriptionActivity","On create");
        setContentView(R.layout.activity_description);
        textView = findViewById(R.id.textView2);
        //String name = getIntent().getStringExtra("name");
        //textView.setText(name);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("myBundle");
        Log.i("Deepak","Deepak");
        String text = bundle.getString("Name") +"\n" + bundle.getString("course");
        textView.setText(text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Deepak DescriptionActivity","On Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Deepak DescriptionActivity","On Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Deepak DescriptionActivity","On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Deepak DescriptionActivity","On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Deepak DescriptionActivity","On Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Deepak DescriptionActivity","On Restart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Deepak DescriptionActivity","On saveinstancestate");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("Deepak DescriptionActivity","On RestoreInstanceState");
    }
}