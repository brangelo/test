package com.fhoster.test.client.view;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.fhoster.test.client.view.grid._DataGrid;
import com.fhoster.test.client.presenter.LtPresenter2;

public class LtView2 extends ViewImpl implements LtPresenter2.MyView {

	FlowPanel container;

	@Inject
	public LtView2() {

		container = new FlowPanel();
		
		container.add(new _DataGrid().asWidget());
		container.add(new _DataGrid().asWidget());
		container.add(new _DataGrid().asWidget());
		container.add(new _DataGrid().asWidget());
		container.add(new _DataGrid().asWidget());
		container.add(new _DataGrid().asWidget());
		container.add(new _DataGrid().asWidget());
		container.add(new _DataGrid().asWidget());
		container.add(new _DataGrid().asWidget());
		container.add(new _DataGrid().asWidget());
		
	}

	@Override
	public Widget asWidget() {
		return container;
	}
}
