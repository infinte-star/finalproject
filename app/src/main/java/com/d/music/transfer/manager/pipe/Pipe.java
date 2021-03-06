package com.d.music.transfer.manager.pipe;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;

import com.d.music.data.database.greendao.bean.TransferModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Pipe
 */
public abstract class Pipe {
    private final static int LIMIT_DEFAULT = 3;

    private int mLimit = LIMIT_DEFAULT;
    private List<List<TransferModel>> mArray = new ArrayList<>();
    protected List<TransferModel> mList = new ArrayList<>();

    public List<TransferModel> mDownloadingQueue = new ArrayList<>();
    public List<TransferModel> mDownloading = new ArrayList<>();
    public List<TransferModel> mDownloaded = new ArrayList<>();

    public abstract void init();

    public void setLimit(int limit) {
        this.mLimit = limit;
    }

    public void list(@NonNull List<TransferModel> datas) {
        datas.clear();
        datas.addAll(mDownloading);
        datas.addAll(mDownloaded);
    }

    @NonNull
    public List<TransferModel> list() {
        return mList;
    }

    /**
     * @return mArray, mArray[0]: mDownloading; mArray[1]: mDownloaded
     */
    @NonNull
    public List<List<TransferModel>> lists() {
        mArray.clear();
        mArray.add(mDownloading);
        mArray.add(mDownloaded);
        return mArray;
    }

    @UiThread
    public void add(TransferModel item) {
        for (int i = 0; i < mList.size(); i++) {
            TransferModel transfer = mList.get(i);
            if (transfer.type.equals(item.type)
                    && TextUtils.equals(transfer.songId, item.songId)) {
                return;
            }
        }
        mDownloading.add(item);
        mList.add(item);
        notifyItemInserted(item);
    }

    @UiThread
    public void push(TransferModel item) {
        mDownloadingQueue.add(item);
        notifyItemChanged(item);
    }

    @UiThread
    public void pop(TransferModel item) {
        mDownloadingQueue.remove(item);
        notifyItemChanged(item);
    }

    @UiThread
    public List<TransferModel> peek() {
        List<TransferModel> list = new ArrayList<>();
        int size = mDownloading.size();
        for (int i = 0; i < size; i++) {
            if (list.size() + mDownloadingQueue.size() >= mLimit) {
                break;
            }
            TransferModel model = mDownloading.get(i);
            if (model.transferState == TransferModel.TRANSFER_STATE_PENDDING) {
                list.add(model);
            }
        }
        return list;
    }

    @UiThread
    public void finish(TransferModel model) {
        mDownloading.remove(model);
        mDownloaded.add(model);
        notifyItemChanged(model);
    }

    @SuppressWarnings("unused")
    @UiThread
    public void remove(TransferModel model) {
        if (!mDownloading.remove(model)) {
            mDownloaded.remove(model);
        }
        mList.remove(model);
        notifyItemMoved(model);
    }

    protected abstract void notifyItemChanged(TransferModel model);

    protected abstract void notifyItemInserted(TransferModel model);

    protected abstract void notifyItemMoved(TransferModel model);
}
