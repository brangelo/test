package com.fhoster.test.client.presenter;

import com.fhoster.test.client.presenter.ApplicationPresenter;
import com.fhoster.test.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class LtPresenter3 extends Presenter<LtPresenter3.MyView, LtPresenter3.MyProxy> {
    public interface MyView extends View {
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.livetable3)
    public interface MyProxy extends ProxyPlace<LtPresenter3> {
    }

    @Inject
    public LtPresenter3(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.TYPE_SetMainContent);
    }
}
