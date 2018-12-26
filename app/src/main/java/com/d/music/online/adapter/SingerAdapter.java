package com.d.music.online.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.d.lib.xrv.adapter.CommonAdapter;
import com.d.lib.xrv.adapter.CommonHolder;
import com.d.music.R;
import com.d.music.online.model.SingerModel;

import java.util.List;

/**
 * SingerAdapter
 */
public class SingerAdapter extends CommonAdapter<SingerModel> {

    public SingerAdapter(Context context, List<SingerModel> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(int position, CommonHolder holder, SingerModel item) {
        holder.setText(R.id.tv_seq, "" + (position + 1));
        holder.setTextColor(R.id.tv_seq, position < 3 ? ContextCompat.getColor(mContext, R.color.lib_pub_color_red)
                : ContextCompat.getColor(mContext, R.color.lib_pub_color_text_sub));
        holder.setText(R.id.tv_singer, "" + item.name);
        holder.setText(R.id.tv_score, mContext.getResources().getString(R.string.module_common_heat)
                + item.score);
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Glide.with(mContext)
                .load(item.img1v1Url)
                .apply(new RequestOptions().dontAnimate())
                .into((ImageView) holder.getView(R.id.iv_cover));
    }
}
