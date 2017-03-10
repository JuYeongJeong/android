package com.payco.lk.user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.payco.lk.databinding.UserMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserMainBinding biding = DataBindingUtil.setContentView(this, R.layout.user_main);
        String str =com.payco.lk.common.MainActivity.getInfo();
        int a = 3;
        a = 2;
    }
}
