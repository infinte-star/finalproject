package com.d.music.component.operation;

import android.content.Context;

import com.d.lib.common.utils.Util;
import com.d.music.component.media.SyncManager;
import com.d.music.data.database.greendao.bean.MusicModel;
import com.d.music.data.database.greendao.db.AppDB;
import com.d.music.play.activity.PlayActivity;
import com.d.music.view.dialog.SongInfoDialog;
import com.d.music.view.popup.AddToListPopup;

import java.util.ArrayList;
import java.util.List;

/**
 * MoreUtil
 */
public class Operater {

    /**
     * 添加到歌单
     *
     * @param context: context
     * @param type:    当前列表标识 - 排除本列表
     * @param model:   model
     */
    public static void addToList(Context context, int type, MusicModel model) {
        List<MusicModel> list = new ArrayList<>();
        list.add(model);
        new AddToListPopup(context, type, list).show();
    }

    /**
     * 收藏/取消收藏
     */
    public static void collect(Context context, int type, MusicModel model, boolean isTip) {
        model.isCollected = !model.isCollected;
        if (type != AppDB.MUSIC) {
            // 通知PlayActivity播放页刷新
            PlayActivity.isNeedReLoad = true;
        }
        SyncManager.updateCollected(context.getApplicationContext(), type, model);
        if (!isTip) {
            return;
        }
        if (model.isCollected) {
            Util.toast(context, "已收藏");
        } else {
            Util.toast(context, "已取消收藏");
        }
    }

    /**
     * 歌曲详情
     */
    public static void showInfo(Context context, MusicModel model) {
        new SongInfoDialog(context, model).show();
    }
}
