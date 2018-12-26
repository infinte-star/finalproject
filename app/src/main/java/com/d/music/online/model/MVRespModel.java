package com.d.music.online.model;

import com.d.lib.common.component.mvp.model.BaseRespModel;

import java.util.List;

/**
 * MVRespModel
 */
public class MVRespModel extends BaseRespModel {

    /**
     * updateTime : 1533986977228
     * data : data
     * hasMore : true
     * code : 200
     */
    public long updateTime;
    public boolean hasMore;
    public int code;
    public List<MVModel> data;
}
