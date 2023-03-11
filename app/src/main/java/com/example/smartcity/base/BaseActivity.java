package com.example.smartcity.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @ClassName BaseActivity
 * @Author name
 * @Date 2023/3/10
 * @Description
 */
abstract public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
    }

    abstract public void initView();
    abstract public int getLayout();
    protected <T extends View> T findId(@IdRes int id){
        return findViewById(id);
    }
}
