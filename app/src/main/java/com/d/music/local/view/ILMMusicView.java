package com.d.music.local.view;


import com.d.lib.common.component.mvp.MvpView;
import com.d.music.data.database.greendao.bean.MusicModel;
import com.d.music.local.model.AlbumModel;
import com.d.music.local.model.FolderModel;
import com.d.music.local.model.SingerModel;

import java.util.List;

/**
 * ILMMusicView
 */
public interface ILMMusicView extends MvpView {
    void setSong(List<MusicModel> models);

    void setSinger(List<SingerModel> models);

    void setAlbum(List<AlbumModel> models);

    void setFolder(List<FolderModel> models);
}
