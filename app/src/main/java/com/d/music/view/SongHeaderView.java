package com.d.music.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.d.lib.common.component.repeatclick.ClickFast;
import com.d.lib.common.utils.Util;
import com.d.music.R;

/**
 * SongHeaderView
 */
public class SongHeaderView extends LinearLayout implements View.OnClickListener {
    private FrameLayout flytPlayAll;
    private LinearLayout llytPlayAll;
    private TextView tvSongCount;
    private FrameLayout flytHandler;
    private OnHeaderListener listener;

    public SongHeaderView(Context context) {
        super(context);
        init(context);
    }

    public SongHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public SongHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Util.dip2px(context, 50)));
        setOrientation(HORIZONTAL);
        View root = LayoutInflater.from(context).inflate(R.layout.module_local_layout_song, this);
        flytPlayAll = (FrameLayout) root.findViewById(R.id.flyt_header_song_play_all);
        llytPlayAll = (LinearLayout) root.findViewById(R.id.llyt_header_song_play_all);
        tvSongCount = (TextView) root.findViewById(R.id.tv_header_song_count);
        flytHandler = (FrameLayout) root.findViewById(R.id.flyt_header_song_handler);
        flytPlayAll.setOnClickListener(this);
        llytPlayAll.setOnClickListener(this);
        flytHandler.setOnClickListener(this);
    }

    public void setSongCount(int count) {
        tvSongCount.setText(String.format(getResources().getString(R.string.module_common_song_unit_format), count));
    }

    public void setVisibility(int resId, int visibility) {
        View v = findViewById(resId);
        if (v != null) {
            v.setVisibility(visibility);
        }
    }

    @Override
    public void onClick(View v) {
        if (ClickFast.isFastDoubleClick()) {
            return;
        }
        switch (v.getId()) {
            case R.id.flyt_header_song_play_all:
            case R.id.llyt_header_song_play_all:
                if (listener != null) {
                    listener.onPlayAll();
                }
                break;
            case R.id.flyt_header_song_handler:
                if (listener != null) {
                    listener.onHandle();
                }
                break;
        }
    }

    public interface OnHeaderListener {
        void onPlayAll();

        void onHandle();
    }

    public void setOnHeaderListener(OnHeaderListener listener) {
        this.listener = listener;
    }
}
