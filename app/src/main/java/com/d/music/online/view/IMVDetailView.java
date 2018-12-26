package com.d.music.online.view;

import com.d.lib.common.component.loader.IAbsView;
import com.d.music.online.model.MVDetailModel;

import java.util.List;

/**
 * IMVDetailView
 */
public interface IMVDetailView extends IAbsView<MVDetailModel> {
    void setInfo(MVDetailModel info);

    void setSimilar(List<MVDetailModel> similar);
}
