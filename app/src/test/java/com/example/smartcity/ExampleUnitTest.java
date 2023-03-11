package com.example.smartcity;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.smartcity.bean.BannerImageBean;
import com.example.smartcity.bean.JavaBean;
import com.example.smartcity.network.Callback;
import com.example.smartcity.network.OkhttpUit;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        OkhttpUit.getInstance().doGet("http://124.93.196.45:10001/prod-api/api/rotation/list?pageNum=2&pageSize=8&type=2", new Callback() {
            @Override
            public void success(String request) {
                Gson gson  =new Gson();
                Type type  = new TypeToken<JavaBean<List<BannerImageBean>>>(){}.getType();
               JavaBean<List<BannerImageBean>> list  = gson.fromJson(request,type );
                System.out.println(list.getRows().get(0).getAdvImg());
            }

            @Override
            public void fail(Exception e) {

            }

        });
        while (true){}
    }
}