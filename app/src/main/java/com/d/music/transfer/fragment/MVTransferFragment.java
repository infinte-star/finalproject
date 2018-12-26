package com.d.music.transfer.fragment;

import android.support.annotation.NonNull;
import android.view.View;

import com.d.lib.xrv.adapter.CommonAdapter;
import com.d.lib.xrv.adapter.MultiItemTypeSupport;
import com.d.music.R;
import com.d.music.data.database.greendao.bean.TransferModel;
import com.d.music.transfer.activity.TransferActivity;
import com.d.music.transfer.adapter.TransferAdapter;
import com.d.music.transfer.manager.TransferManager;
import com.d.music.transfer.manager.operation.Operater;

import java.util.ArrayList;
import java.util.List;

/**
 * MVTransferFragment
 */
public class MVTransferFragment extends TransferFragment {

    @NonNull
    @Override
    protected Operater getOperater() {
        return TransferManager.getIns().optMV();
    }

    @Override
    protected CommonAdapter<TransferModel> getAdapter() {
        return new TransferAdapter(mContext, new ArrayList<TransferModel>(), type,
                new MultiItemTypeSupport<TransferModel>() {
                    @Override
                    public int getLayoutId(int viewType) {
                        switch (viewType) {
                            case TransferModel.TRANSFER_TYPE_HEAD_NOT:
                                return R.layout.module_transfer_adapter_head_downloading;
                            case TransferModel.TRANSFER_TYPE_HEAD_DONE:
                                return R.layout.module_transfer_adapter_head_downloaded;
                            case TransferModel.TRANSFER_TYPE_MV:
                            default:
                                return R.layout.module_transfer_adapter_mv;
                        }
                    }

                    @Override
                    public int getItemViewType(int position, TransferModel model) {
                        return model.transferType;
                    }
                });
    }

    @Override
    public void notifyDataSetChanged(List<List<TransferModel>> lists) {
        final int countDownloading = lists.get(0).size();
        ((TransferActivity) getActivity()).setTabNumber(type,
                countDownloading > 0 ? "" + countDownloading : "",
                countDownloading > 0 ? View.VISIBLE : View.GONE);
        super.notifyDataSetChanged(lists);
    }
}
