package com.d.music.component.glide;

import android.support.annotation.NonNull;

import com.bumptech.glide.annotation.GlideModule;
import com.d.lib.common.component.glide.AbstractGlideModule;
import com.d.music.data.Constants;

/**
 * Glide global configuration
 */
@GlideModule
public class AppGlideModuleConfig extends AbstractGlideModule {

    @NonNull
    @Override
    protected String getCachePath() {
        return Constants.Path.glide_cache;
    }
}
