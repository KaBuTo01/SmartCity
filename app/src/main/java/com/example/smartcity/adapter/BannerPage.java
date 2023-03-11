package com.example.smartcity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity.R;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

/**
 * @ClassName BannerPage
 * @Author name
 * @Date 2023/3/10
 * @Description
 */
public class BannerPage extends BannerAdapter<String, BannerPage.ViewHolder> {
    final  static private int END = 1;
    final static private int NORMAL = 0;

    private OnClickListener onClickListener;
    public BannerPage(List<String> datas) {
        super(datas);
    }

    @Override
    public ViewHolder onCreateHolder(ViewGroup viewGroup, int i) {
        ViewHolder viewHolder = null;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.in_dy_ty_end_item,viewGroup,false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getRealCount() ){
            return END;
        }
        return NORMAL;
    }
    public interface OnClickListener {
        void onNetWorkSetting();
        void onInHome();
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onBindView(ViewHolder viewHolder, String s, int i, int i1) {
        Glide.with(viewHolder.itemView).load(s).into(viewHolder.imageView);
        if (getItemViewType(i+1)==END){
            viewHolder.nws.setVisibility(View.VISIBLE);
            viewHolder.inHome.setVisibility(View.VISIBLE);
        }
        viewHolder.nws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onNetWorkSetting();
                viewHolder.div.setVisibility(View.VISIBLE);
            }
        });
        viewHolder.inHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onInHome();
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout div;
        private  EditText inputIp;
        private  EditText inputCn;
        private  ImageView imageView;
        private Button nws;
        private Button inHome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            nws  = itemView.findViewById(R.id.net_work_setting);
            inHome  =itemView.findViewById(R.id.in_home);
            div = itemView.findViewById(R.id.div);
            inputIp = itemView.findViewById(R.id.input_ip);
            inputCn = itemView.findViewById(R.id.input_cn);
            nws.setVisibility(View.GONE);
            inHome.setVisibility(View.GONE);
            div.setVisibility(View.GONE);
        }
    }

}
