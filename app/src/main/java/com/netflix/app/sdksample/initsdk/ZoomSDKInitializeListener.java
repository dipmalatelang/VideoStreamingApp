package com.netflix.app.sdksample.initsdk;


import us.zoom.androidlib.util.IListener;

public interface ZoomSDKInitializeListener extends IListener {
    void onZoomSDKInitializeResult(int i, int i1);

    void onZoomAuthIdentityExpired();
}