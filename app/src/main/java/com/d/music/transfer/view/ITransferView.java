package com.d.music.transfer.view;

import com.d.lib.common.component.loader.IAbsView;
import com.d.music.data.database.greendao.bean.TransferModel;

import java.util.List;

/**
 * ITransferView
 */
public interface ITransferView extends IAbsView<TransferModel> {
    void notifyDataSetChanged(List<List<TransferModel>> lists);
}
