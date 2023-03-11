package com.example.smartcity.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @ClassName OkhttpUit
 * @Author name
 * @Date 2023/3/11
 * @Description
 */
public class OkhttpUit extends OkHttpClient {
    private static  OkhttpUit instance;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private  Handler handler = new Handler(Looper.getMainLooper());
    public static OkhttpUit getInstance() {
        if (instance == null){
            synchronized (OkhttpUit.class){
                if (instance == null){
                    return new OkhttpUit();
                }
            }
        }
        return instance;
    }

    public void doGet(String url ,com.example.smartcity.network.Callback callback){
//        SharedPreferences sharedPreferences = context.getSharedPreferences("name",Context.MODE_PRIVATE);
//        String ip = sharedPreferences.getString("ip","http://124.93.196.45");
//        String cn =  sharedPreferences.getString("cn",":10001");
        Request request  = new Request.Builder().url(url).build();
        Call call = newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(e);
                    }
                });



            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String data = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {


                            callback.success(data);

                    }
                });
            }
        });
    }
}
