package com.kumardsingh.mvpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.MessageFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IView {

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);

        

        //Interface that acts as intermediate class between view an model
        IPresenter presenter = new Presenter(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               presenter.clickHandler();
            }
        });

    }
    @Override
    public void setText(String msg) {
        mTextView.setText(msg);
    }
}