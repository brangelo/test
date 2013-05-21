///**
// * Copyright 2012 ArcBees Inc.
// *
// * Licensed under the Apache License, Version 2.0 (the "License"); you may not
// * use this file except in compliance with the License. You may obtain a copy of
// * the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
// * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
// * License for the specific language governing permissions and limitations under
// * the License.
// */
//
//package com.fhoster.test.client.view;
//
//import com.fhoster.livetable.client.LiveTable;
//import com.fhoster.livetable.client.LiveTablePreferences;
//import com.fhoster.livetable.client.SkinType;
//import com.fhoster.livetable.client.WP_Unlimited;
//import com.fhoster.livetable.client.datasource.LiveTableDataSource;
//import com.fhoster.livetable.client.datasource.proxyDataSource.LiveTableServantProxy;
//import com.fhoster.livetable.client.datasource.proxyDataSource.LivetableServantKey;
//import com.fhoster.test.client.presenter.LtPresenter;
//import com.fhoster.test.client.view.grid._DataGrid;
//import com.google.gwt.user.client.ui.FlowPanel;
//import com.google.gwt.user.client.ui.Widget;
//import com.google.inject.Inject;
//import com.gwtplatform.mvp.client.ViewImpl;
//
//public class LtView extends ViewImpl implements LtPresenter.MyView {
//
//	FlowPanel container;
//
//	@Inject
//	public LtView() {
//
//		final LiveTableDataSource dataSource = new LiveTableServantProxy(new LivetableServantKey<String>("lts001"), "LTServlet");
//		final LiveTablePreferences prefs = new LiveTablePreferences(new WP_Unlimited(), 15, SkinType.EF);
//		final LiveTable lt = new LiveTable(dataSource, prefs);
//		lt.clearSelection();
//		lt.clearSearch();
//		
//		container = new FlowPanel();
//		container.add(lt);
//		container.add(new _DataGrid().asWidget());
//	}
//
//	@Override
//	public Widget asWidget() {
//		return container;
//	}
//}
