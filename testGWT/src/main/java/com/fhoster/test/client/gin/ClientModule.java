package com.fhoster.test.client.gin;

import com.fhoster.test.client.place.NameTokens;
import com.fhoster.test.client.presenter.ApplicationPresenter;
import com.fhoster.test.client.presenter.HomePagePresenter;
import com.fhoster.test.client.presenter.MenuPresenter;
import com.fhoster.test.client.presenter.PageOnePresenter;
import com.fhoster.test.client.presenter.PageThreePresenter;
import com.fhoster.test.client.presenter.PageTwoPresenter;
import com.fhoster.test.client.view.ApplicationView;
import com.fhoster.test.client.view.HomePageView;
import com.fhoster.test.client.view.MenuView;
import com.fhoster.test.client.view.PageOneView;
import com.fhoster.test.client.view.PageThreeView;
import com.fhoster.test.client.view.PageTwoView;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.client.proxy.DefaultPlaceManager;
import com.fhoster.test.client.presenter.LtPresenter1;
import com.fhoster.test.client.view.LtView1;
import com.fhoster.test.client.presenter.LtPresenter2;
import com.fhoster.test.client.view.LtView2;
import com.fhoster.test.client.presenter.LtPresenter3;
import com.fhoster.test.client.view.LtView3;
		
public class ClientModule extends AbstractPresenterModule {
	
	@Override
	protected void configure() {
		install(new DefaultModule(DefaultPlaceManager.class));

		bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
				ApplicationPresenter.MyProxy.class);

		// DefaultPlaceManager Places
		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);
		bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.home);
		bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.home);

		bindPresenter(MenuPresenter.class, MenuPresenter.MyView.class, MenuView.class,
				MenuPresenter.MyProxy.class);
		bindPresenter(HomePagePresenter.class, HomePagePresenter.MyView.class, HomePageView.class,
				HomePagePresenter.MyProxy.class);
		bindPresenter(PageOnePresenter.class, PageOnePresenter.MyView.class, PageOneView.class,
				PageOnePresenter.MyProxy.class);
		bindPresenter(PageTwoPresenter.class, PageTwoPresenter.MyView.class, PageTwoView.class,
				PageTwoPresenter.MyProxy.class);
		bindPresenter(PageThreePresenter.class, PageThreePresenter.MyView.class, PageThreeView.class,
				PageThreePresenter.MyProxy.class);
		//bindPresenter(LtPresenter.class, LtPresenter.MyView.class, LtView.class, LtPresenter.MyProxy.class);
				
		 		bindPresenter(LtPresenter1.class, LtPresenter1.MyView.class, LtView1.class,
				LtPresenter1.MyProxy.class);
		 		bindPresenter(LtPresenter2.class, LtPresenter2.MyView.class, LtView2.class,
				LtPresenter2.MyProxy.class);
		 		bindPresenter(LtPresenter3.class, LtPresenter3.MyView.class, LtView3.class,
				LtPresenter3.MyProxy.class);
			}
}
