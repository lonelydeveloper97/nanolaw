package com.lonelydeveloper97.nanolaw.cards.single;

import com.lonelydeveloper97.nanolaw.mvp.BasePresenter;
import com.lonelydeveloper97.nanolaw.mvp.BaseView;
import com.lonelydeveloper97.nanolaw.cards.single.impl.model.Card;

public interface SingleCardContract {

    interface Presenter extends BasePresenter<View>{}

    interface View extends BaseView<Presenter>{
        void setCard(Card card);
    }
}
