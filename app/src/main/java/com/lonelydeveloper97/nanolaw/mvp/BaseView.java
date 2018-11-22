package com.lonelydeveloper97.nanolaw.mvp;


public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
}
