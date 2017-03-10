package com.payco.lk.common;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.payco.lk.BuildConfig;
import com.payco.lk.R;
import com.payco.lk.databinding.MainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainBinding binding = DataBindingUtil.setContentView(this, R.layout.main);

    }

    public static String getInfo(){
        return BuildConfig.APPLICATION_ID;
    }
}
