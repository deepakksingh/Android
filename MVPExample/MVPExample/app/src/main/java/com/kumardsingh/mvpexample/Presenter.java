package com.kumardsingh.mvpexample;

import android.icu.text.NumberFormat;
import android.view.View;
import java.util.Random;



public class Presenter implements IPresenter {
    IView iView;
    public Presenter(IView view){
        this.iView = view;
    }

    @Override
    public void clickHandler() {
        int rnd = (new Random()).nextInt(1000);
        iView.setText(Integer.toString(rnd));
    }
}
