package com.d.music.setting.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.d.lib.xrv.adapter.CommonAdapter;
import com.d.lib.xrv.adapter.CommonHolder;
import com.d.music.R;
import com.d.music.data.preferences.Preferences;
import com.d.music.setting.model.RadioModel;
import com.d.music.view.dialog.TimingDialog;

import java.util.List;

/**
 * TimingAdapter
 */
public class TimingAdapter extends CommonAdapter<RadioModel> {
    private int index;
    private OnChangeListener listener;

    public TimingAdapter(Context context, List<RadioModel> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void convert(final int position, final CommonHolder holder, final RadioModel item) {
        holder.setText(R.id.tv_content, item.content);
        holder.setViewVisibility(R.id.iv_check, item.isChecked ? View.VISIBLE : View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == getItemCount() - 1) {
                    TimingDialog dialog = new TimingDialog(mContext);
                    dialog.setOnTimingListener(new TimingDialog.OnTimingListener() {
                        @Override
                        public void onSubmit(long time) {
                            Preferences.getIns(mContext.getApplicationContext()).putSleepType(6);
                            ((Activity) mContext).finish();
                        }

                        @Override
                        public void onCancel() {

                        }
                    });
                    dialog.show();
                    return;
                }
                if (!item.isChecked) {
                    item.isChecked = true;
                    if (index >= 0 && index < mDatas.size()) {
                        mDatas.get(index).isChecked = false;
                    }
                    index = position;
                    notifyDataSetChanged();
                    if (listener != null) {
                        listener.onChange(position);
                    }
                }
            }
        });
    }

    public interface OnChangeListener {
        void onChange(int index);
    }

    public void setOnChangeListener(OnChangeListener listener) {
        this.listener = listener;
    }
}
