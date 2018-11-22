package com.lonelydeveloper97.nanolaw.mvp;

public interface BasePresenter<V extends BaseView> {
    void subscribe(V view);
    void unsubscribe();
}
