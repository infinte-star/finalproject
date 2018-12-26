package com.d.music.online.presenter;

import android.content.Context;

import com.d.lib.common.component.loader.CommonLoader;
import com.d.lib.common.component.loader.IAbsView;
import com.d.lib.common.component.mvp.MvpBasePresenter;
import com.d.lib.rxnet.RxNet;
import com.d.lib.rxnet.base.Params;
import com.d.lib.rxnet.callback.SimpleCallback;
import com.d.music.api.API;
import com.d.music.online.model.MVModel;
import com.d.music.online.model.MVRespModel;

/**
 * MVPresenter
 */
public class MVPresenter extends MvpBasePresenter<IAbsView<MVModel>> {

    public MVPresenter(Context context) {
        super(context);
    }

    public void getMV(int page) {
        int offset = CommonLoader.PAGE_COUNT * (page - 1);
        int limit = CommonLoader.PAGE_COUNT;
        Params params = new Params(API.MVTop.rtpType);
        params.addParam(API.MVTop.offset, "" + offset);
        params.addParam(API.MVTop.limit, "" + limit);
        RxNet.get(API.MVTop.rtpType, params)
                .request(new SimpleCallback<MVRespModel>() {
                    @Override
                    public void onSuccess(MVRespModel response) {
                        if (getView() == null) {
                            return;
                        }
                        getView().setData(response.data);
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
