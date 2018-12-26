package com.d.music.transfer.activity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.d.lib.common.component.loader.AbsFragmentActivity;
import com.d.lib.common.view.TitleLayout;
import com.d.music.R;
import com.d.music.transfer.fragment.TransferFragment;
import com.d.music.transfer.manager.TransferManager;
import com.d.music.utils.StatusBarCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import cn.feng.skin.manager.loader.SkinManager;

/**
 * TransferActivity
 */
public class TransferActivity extends AbsFragmentActivity {
    @BindView(R.id.tl_title)
    TitleLayout tlTitle;

    @Override
    protected List<String> getTitles() {
        return Arrays.asList(getResources().getString(R.string.module_common_song),
                getResources().getString(R.string.module_common_online_mv));
    }

    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(TransferFragment.getFragment(TransferFragment.TYPE_SONG));
        fragments.add(TransferFragment.getFragment(TransferFragment.TYPE_MV));
        return fragments;
    }

    @Override
    protected void init() {
        super.init();
        StatusBarCompat.compat(this, SkinManager.getInstance().getColor(R.color.lib_pub_color_main));
        tlTitle.setText(R.id.tv_title_title, getResources().getString(R.string.module_common_transfer));
        final int countSongDownloading = TransferManager.getIns().optSong().pipe().lists().get(0).size();
        final int countMVDownloading = TransferManager.getIns().optMV().pipe().lists().get(0).size();
        setTabNumber(TransferFragment.TYPE_SONG,
                countSongDownloading > 0 ? "" + countSongDownloading : "",
                countSongDownloading > 0 ? View.VISIBLE : View.GONE);
        setTabNumber(TransferFragment.TYPE_MV,
                countMVDownloading > 0 ? "" + countMVDownloading : "",
                countMVDownloading > 0 ? View.VISIBLE : View.GONE);
    }

    public void setTabNumber(int position, String text, int visibility) {
        if (indicator == null) {
            return;
        }
        indicator.setNumber(position, text, visibility);
    }
}
