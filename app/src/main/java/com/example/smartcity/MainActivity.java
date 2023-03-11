package com.example.smartcity;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartcity.adapter.BannerImageTitleNum;
import com.example.smartcity.base.BaseActivity;
import com.example.smartcity.bean.BannerImageBean;
import com.example.smartcity.bean.JavaBean;
import com.example.smartcity.network.Callback;
import com.example.smartcity.network.OkhttpUit;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.youth.banner.Banner;

import java.util.List;

public class MainActivity extends BaseActivity {

    private Banner banner;
    private TextView text;

    @Override
    public void initView() {
        banner = findId(R.id.banner);
        text = findId(R.id.text);
        OkhttpUit.getInstance().doGet("http://124.93.196.45:10001/prod-api/api/rotation/list?pageNum=2&pageSize=8&type=2",new Callback() {
            @Override
            public void success(String request) {

                Gson gson = new Gson();
                JavaBean<List<BannerImageBean>> list = gson.fromJson(request,new TypeToken<JavaBean<List<BannerImageBean>>>(){}.getType());
                banner.setAdapter(new BannerImageTitleNum(list.getRows(),MainActivity.this));
            }
            @Override
            public void fail(Exception e) {
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }
}