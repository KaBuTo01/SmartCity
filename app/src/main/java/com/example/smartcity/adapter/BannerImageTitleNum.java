package com.example.smartcity.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity.R;
import com.example.smartcity.bean.BannerImageBean;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

/**
 * @ClassName BannerImageTitleNum
 * @Author name
 * @Date 2023/3/11
 * @Description
 */
public class BannerImageTitleNum extends BannerAdapter<BannerImageBean,BannerImageTitleNum.ViewHolder> {

    private Context context;
    public BannerImageTitleNum(List<BannerImageBean> datas, Context context) {
        super(datas);
        this.context = context;
    }

    @Override
    public ViewHolder onCreateHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_title_num,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindView(ViewHolder viewHolder, BannerImageBean bannerImageBean, int i, int i1) {
        SharedPreferences sp = context.getSharedPreferences("name",Context.MODE_PRIVATE);
        Glide.with(context).load("http://124.93.196.45"+":10001"+bannerImageBean.getAdvImg()).into(viewHolder.image);
        viewHolder.title.setText(bannerImageBean.getAdvTitle());
        viewHolder.num.setText((i+1)+"/"+getRealCount());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView image;
        private  TextView title;
        private  TextView num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            num = itemView.findViewById(R.id.num);
        }
    }
}
