package com.d.music.online.presenter;

import android.content.Context;

import com.d.lib.common.component.loader.IAbsView;
import com.d.lib.common.component.mvp.MvpBasePresenter;
import com.d.lib.rxnet.RxNet;
import com.d.lib.rxnet.base.Params;
import com.d.lib.rxnet.callback.SimpleCallback;
import com.d.music.api.API;
import com.d.music.online.model.RadioModel;
import com.d.music.online.model.RadioRespModel;

/**
 * RadioPresenter
 */
public class RadioPresenter extends MvpBasePresenter<IAbsView<RadioModel>> {

    public RadioPresenter(Context context) {
        super(context);
    }

    public void getRadio() {
        Params params = new Params(API.RadioChannels.rtpType);
        params.addParam(API.RadioChannels.from, "qianqian");
        params.addParam(API.RadioChannels.version, "2.1.0");
        params.addParam(API.RadioChannels.method, API.Baidu.METHOD_GET_CATEGORY_LIST);
        params.addParam(API.RadioChannels.format, "json");
        RxNet.get(API.BaiduBill.rtpType, params)
                .request(new SimpleCallback<RadioRespModel>() {
                    @Override
                    public void onSuccess(RadioRespModel response) {
                        if (getView() == null) {
                            return;
                        }
                        getView().setData(response.result.get(0).channellist);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() == null) {
                            return;
                        }
                        getView().loadError();
                    }
                });
    }
}
