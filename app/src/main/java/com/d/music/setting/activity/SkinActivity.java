package com.d.music.setting.activity;

import android.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.d.lib.common.component.mvp.MvpBasePresenter;
import com.d.lib.common.component.mvp.MvpView;
import com.d.lib.common.component.mvp.base.BaseActivity;
import com.d.lib.common.component.repeatclick.ClickFast;
import com.d.lib.common.utils.Util;
import com.d.lib.common.view.dialog.AlertDialogFactory;
import com.d.music.R;
import com.d.music.component.skin.SkinUtil;
import com.d.music.data.preferences.Preferences;
import com.d.music.setting.adapter.SkinAdapter;
import com.d.music.setting.model.RadioModel;
import com.d.music.utils.StatusBarCompat;
import com.d.music.view.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.feng.skin.manager.listener.ILoaderListener;
import cn.feng.skin.manager.loader.SkinManager;

/**
 * SkinActivity
 */
public class SkinActivity extends BaseActivity<MvpBasePresenter> implements MvpView {
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private int index;
    private SkinAdapter adapter;
    private AlertDialog dialog;

    @OnClick({R.id.iv_title_left, R.id.tv_title_right})
    public void onClickListener(View v) {
        if (ClickFast.isFastDoubleClick()) {
            return;
        }
        switch (v.getId()) {
            case R.id.iv_title_left:
                finish();
                break;
            case R.id.tv_title_right:
                index = adapter.getIndex();
                SkinUtil.load(getApplicationContext(), index, new ILoaderListener() {
                    @Override
                    public void onStart() {
                        showLoading();
                    }

                    @Override
                    public void onSuccess() {
                        closeLoading();
                        finish();
                    }

                    @Override
                    public void onFailed() {
                        closeLoading();
                        Util.toast(getApplicationContext(), getResources().getString(R.string.module_common_skinning_error));
                    }
                });
                break;
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.module_setting_activity_skin;
    }

    @Override
    public MvpBasePresenter getPresenter() {
        return new MvpBasePresenter(getApplicationContext());
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    protected void init() {
        StatusBarCompat.compat(this, SkinManager.getInstance().getColor(R.color.lib_pub_color_main));
        index = Preferences.getIns(getApplicationContext()).getSkinType();
        adapter = new SkinAdapter(this, getDatas(index), R.layout.module_setting_adapter_skin);
        adapter.setIndex(index);
        rvList.setLayoutManager(new GridLayoutManager(this, 3));
        rvList.addItemDecoration(new SpaceItemDecoration(Util.dip2px(this, 6)));
        rvList.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        if (dialog == null) {
            dialog = AlertDialogFactory.createFactory(this)
                    .getLoadingDialog(getResources().getString(R.string.module_common_skinning));
        }
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void closeLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private List<RadioModel> getDatas(int index) {
        List<RadioModel> datas = new ArrayList<>();
        for (int i = -1; i < SkinUtil.SKIN_COUNT; i++) {
            RadioModel model = new RadioModel();
            model.color = getSkinColor(i);
            model.isChecked = (i == index);
            datas.add(model);
        }
        return datas;
    }

    private int getSkinColor(int index) {
        switch (index) {
            case 0:
                return R.color.color_main_skin0;
            case 1:
                return R.color.color_main_skin1;
            case 2:
                return R.color.color_main_skin2;
            case 3:
                return R.color.color_main_skin3;
            case 4:
                return R.color.color_main_skin4;
            case 5:
                return R.color.color_main_skin5;
            case 6:
                return R.color.color_main_skin6;
            case 7:
                return R.color.color_main_skin7;
            case 8:
                return R.color.color_main_skin8;
            case 9:
                return R.color.color_main_skin9;
            case 10:
                return R.color.color_main_skin10;
            case 11:
                return R.color.color_main_skin11;
            case 12:
                return R.color.color_main_skin12;
            case 13:
                return R.color.color_main_skin13;
            case 14:
                return R.color.color_main_skin14;
            case 15:
                return R.color.color_main_skin15;
            case 16:
                return R.color.color_main_skin16;
            case 17:
                return R.color.color_main_skin17;
            default:
                return R.color.color_main_skin;
        }
    }

    @Override
    public void onThemeUpdate() {
        super.onThemeUpdate();
        StatusBarCompat.compat(this, SkinManager.getInstance().getColor(R.color.lib_pub_color_main));
    }
}
