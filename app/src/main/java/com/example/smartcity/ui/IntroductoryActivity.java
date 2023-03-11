package com.example.smartcity.ui;

import android.content.Intent;
import android.widget.Toast;

import com.example.smartcity.MainActivity;
import com.example.smartcity.R;
import com.example.smartcity.adapter.BannerPage;
import com.example.smartcity.base.BaseActivity;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IntroductoryActivity
 * @Author name
 * @Date 2023/3/10
 * @Description
 */
public class IntroductoryActivity extends BaseActivity {

    private Banner banner;

    @Override
    public void initView() {
        banner = findId(R.id.banner);
        List<String> list = new ArrayList<>();
        list.add("https://tse2-mm.cn.bing.net/th/id/OIP-C.cOx7-MsQrak6oyDxXllBfQHaE7?pid=ImgDet&rs=1");
        list.add("https://img.zcool.cn/community/01f66b5c7cda33a801203d2259faa1.jpg@1280w_1l_2o_100sh.jpg");
        list.add("https://img.zcool.cn/community/01cecb5d390484a80120695c1d523e.jpg@1280w_1l_2o_100sh.jpg");
        list.add("https://img.zcool.cn/community/017dc05d392186a8012187f4a56a82.jpg@1280w_1l_2o_100sh.jpg");
        BannerPage bannerPage = new BannerPage(list);
        banner.setAdapter(bannerPage)
              .isAutoLoop(false)
              .setIndicator(new CircleIndicator(this));
        bannerPage.setOnClickListener(new BannerPage.OnClickListener() {
            @Override
            public void onNetWorkSetting() {

                Toast.makeText(IntroductoryActivity.this,"网络设置",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onInHome() {
                Toast.makeText(IntroductoryActivity.this,"进入主页",Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(IntroductoryActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.in_du_ty;
    }
}
