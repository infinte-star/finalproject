package com.d.music.view.dialog;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.d.lib.common.view.dialog.AbsSheetDialog;
import com.d.lib.xrv.adapter.CommonAdapter;
import com.d.lib.xrv.adapter.CommonHolder;
import com.d.music.R;

import java.util.ArrayList;
import java.util.List;

/**
 * OperationDialog.
 */
public class OperationDialog extends AbsSheetDialog<OperationDialog.Bean> {
    public final static int TYPE_NORMAL = 0;
    public final static int TYPE_NIGHT = 1;

    public int type;

    public static OperationDialog getOperationDialog(Context context, int type, String title, List<OperationDialog.Bean> datas,
                                                     AbsSheetDialog.OnItemClickListener<OperationDialog.Bean> listener) {
        OperationDialog dialog = new OperationDialog(context, type, title, new ArrayList<>(datas));
        dialog.setOnItemClickListener(listener);
        dialog.show();
        return dialog;
    }

    private OperationDialog(Context context, int type, String title, List<OperationDialog.Bean> datas) {
        super(context);
        this.type = type;
        this.title = title;
        this.datas = datas;
        initView(rootView);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.module_play_dialog_operation;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new OperationDialog.SheetAdapter(context, datas, R.layout.module_play_adapter_operation);
    }

    @Override
    protected void initView(View rootView) {
        initRecyclerList(rootView, R.id.rv_list, LinearLayoutManager.HORIZONTAL);

        TextView tvCancle = (TextView) rootView.findViewById(R.id.tv_cancle);
        TextView tvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        } else {
            tvTitle.setVisibility(View.GONE);
        }

        // Change Skin
        rootView.setBackgroundResource(type == TYPE_NIGHT ?
                R.color.color_popup_more_bg : R.color.color_popup_more_bg_light);
        tvCancle.setTextColor(type == TYPE_NIGHT ? ContextCompat.getColor(context, R.color.color_popup_more)
                : ContextCompat.getColor(context, R.color.color_popup_more_light));
        rootView.findViewById(R.id.v_bottom_line).setBackgroundResource(type == TYPE_NIGHT ?
                R.color.color_popup_more_line : R.color.color_popup_more_line_light);

        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(-1, null);
            }
        });
    }

    public class SheetAdapter extends CommonAdapter<OperationDialog.Bean> {
        SheetAdapter(Context context, List<OperationDialog.Bean> datas, int layoutId) {
            super(context, datas, layoutId);
        }

        @Override
        public void convert(final int position, CommonHolder holder, final OperationDialog.Bean item) {
            // Change Skin
            holder.setBackground(R.id.iv_item, type == TYPE_NIGHT ?
                    R.drawable.module_common_corner_more : R.drawable.module_common_corner_more_light);
            holder.setTextColor(R.id.tv_item, type == TYPE_NIGHT ?
                    ContextCompat.getColor(mContext, R.color.color_popup_more)
                    : ContextCompat.getColor(mContext, R.color.color_popup_more_light));

            holder.setImageResource(R.id.iv_item, item.drawble);
            holder.setText(R.id.tv_item, item.item);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick(position, item);
                }
            });
        }
    }

    public static class Bean {
        public final static int TYPE_ADDLIST = 0;
        public final static int TYPE_FAV = 1;
        public final static int TYPE_RING = 2;
        public final static int TYPE_ADJUSTLRC = 3;
        public final static int TYPE_INFO = 4;
        public final static int TYPE_DELETE = 5;
        public final static int TYPE_EDIT = 6;
        public final static int TYPE_DOWNLOAD = 7;
        public final static int TYPE_SEARCH_LRC = 8;
        public final static int TYPE_CHANGE_MODE = 9;
        public final static int TYPE_SETTING = 10;
        public final static int TYPE_EXIT = 11;


        public int type;
        public String item;
        public int drawble;

        public Bean() {
        }

        public Bean(int type, String item, int drawble) {
            this.type = type;
            this.item = item;
            this.drawble = drawble;
        }

        public Bean item(String item) {
            this.item = item;
            return this;
        }

        public Bean with(Context context, int type, boolean night) {
            context = context.getApplicationContext();
            this.type = type;
            switch (type) {
                case TYPE_ADDLIST:
                    this.item = context.getResources().getString(R.string.module_common_add_to_list);
                    this.drawble = night ? R.drawable.module_common_ic_song_addlist_m : R.drawable.module_common_ic_song_addlist_lm;
                    break;
                case TYPE_FAV:
                    this.item = context.getResources().getString(R.string.module_common_collect);
                    this.drawble = night ? R.drawable.module_common_ic_song_fav_m : R.drawable.module_common_ic_song_fav_lm;
                    break;
                case TYPE_RING:
                    this.item = context.getResources().getString(R.string.module_common_set_ring);
                    this.drawble = night ? R.drawable.module_common_ic_song_ring_m : R.drawable.module_common_ic_song_ring_lm;
                    break;
                case TYPE_ADJUSTLRC:
                    this.item = context.getResources().getString(R.string.module_common_set_lrc);
                    this.drawble = night ? R.drawable.module_common_ic_song_adjust_lrc_m : R.drawable.module_common_ic_song_adjust_lrc_lm;
                    break;
                case TYPE_INFO:
                    this.item = context.getResources().getString(R.string.module_common_song_info);
                    this.drawble = night ? R.drawable.module_common_ic_song_info_m : R.drawable.module_common_ic_song_info_lm;
                    break;
                case TYPE_DELETE:
                    this.item = context.getResources().getString(R.string.module_common_delete);
                    this.drawble = night ? R.drawable.module_common_ic_song_delete_m : R.drawable.module_common_ic_song_delete_lm;
                    break;
                case TYPE_EDIT:
                    this.item = context.getResources().getString(R.string.module_common_edit);
                    this.drawble = night ? R.drawable.module_common_ic_song_edit_m : R.drawable.module_common_ic_song_edit_lm;
                    break;
                case TYPE_DOWNLOAD:
                    this.item = context.getResources().getString(R.string.module_common_download);
                    this.drawble = night ? R.drawable.module_common_ic_song_edit_m : R.drawable.module_common_ic_song_edit_lm;
                    break;
                case TYPE_SEARCH_LRC:
                    this.item = context.getResources().getString(R.string.module_common_search_lrc);
                    this.drawble = night ? R.drawable.module_common_ic_song_search_lrc_m : R.drawable.module_common_ic_song_search_lrc_lm;
                    break;
                case TYPE_CHANGE_MODE:
                    this.item = context.getResources().getString(R.string.module_common_mode_switch);
                    this.drawble = night ? R.drawable.module_common_ic_song_edit_m : R.drawable.module_common_ic_song_edit_lm;
                    break;
                case TYPE_SETTING:
                    this.item = context.getResources().getString(R.string.module_common_setting);
                    this.drawble = night ? R.drawable.module_common_ic_song_edit_m : R.drawable.module_common_ic_song_edit_lm;
                    break;
                case TYPE_EXIT:
                    this.item = context.getResources().getString(R.string.module_common_exit);
                    this.drawble = night ? R.drawable.module_setting_ic_menu_exit : R.drawable.module_setting_ic_menu_exit;
                    break;
            }
            return this;
        }
    }
}