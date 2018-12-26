package com.d.music.online.view;

import com.d.lib.common.component.loader.IAbsView;
import com.d.music.data.database.greendao.bean.MusicModel;
import com.d.music.online.model.BillSongsRespModel;
import com.d.music.online.model.RadioSongsRespModel;

/**
 * IMusicView
 */
public interface IMusicView extends IAbsView<MusicModel> {
    void setInfo(BillSongsRespModel info);

    void setInfo(RadioSongsRespModel info);
}
