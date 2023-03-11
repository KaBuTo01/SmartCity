package com.example.smartcity.ui;

import android.content.Intent;
import android.content.SharedPreferences;

import com.example.smartcity.MainActivity;
import com.example.smartcity.R;
import com.example.smartcity.base.BaseActivity;

/**
 * @ClassName InDuTyPage
 * @Author name
 * @Date 2023/3/10
 * @Description
 */
public class InDuTyPage extends BaseActivity {
    @Override
    public void initView() {
        SharedPreferences sp = getSharedPreferences("name",MODE_PRIVATE);
        boolean is = sp.getBoolean("ok",true);
        sp.edit().putString("ip","http://124.93.196.45");
        sp.edit().putString("cn",":10001");
        if (is) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("ok",false);
            editor.apply();
            Intent intent  =new Intent(InDuTyPage.this, IntroductoryActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else{
            Intent intent  = new Intent(InDuTyPage.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.in_du_ty_page;
    }
}
