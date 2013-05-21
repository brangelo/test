package com.fhoster.test.client.view;

import com.fhoster.test.client.place.NameTokens;
import com.fhoster.test.client.presenter.MenuPresenter;
import com.fhoster.test.client.presenter.MenuUiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class MenuView extends ViewWithUiHandlers<MenuUiHandler> implements MenuPresenter.MyView {

 FlowPanel container;
 Button home;
 Button page1;
 Button page2;
 Button page3;
 //Button livetable;

  Button livetable1;
  Button livetable2;
  Button livetable3;
 
 @Inject
 public MenuView() {
  container = new FlowPanel();

  page1 = new Button("page 1");
  page2 = new Button("page 2");
  page3 = new Button("page 3");
  home = new Button("home");
 //livetable = new Button("livetable");

  container.add(page1);
  container.add(page2);
  container.add(page3);
  container.add(home);
 //container.add(livetable);

    initLtButton1();
    initLtButton2();
    initLtButton3();
  
  initHandler();
 }


  private void initLtButton1(){
   livetable1 = new Button("livetable1");
   container.add(livetable1);
   livetable1.addClickHandler(new ClickHandler() {

    @Override
    public void onClick(ClickEvent event) {
     getUiHandlers().onLinkClicked(NameTokens.livetable1);
    }
   });
  }

  private void initLtButton2(){
   livetable2 = new Button("livetable2");
   container.add(livetable2);
   livetable2.addClickHandler(new ClickHandler() {

    @Override
    public void onClick(ClickEvent event) {
     getUiHandlers().onLinkClicked(NameTokens.livetable2);
    }
   });
  }

  private void initLtButton3(){
   livetable3 = new Button("livetable3");
   container.add(livetable3);
   livetable3.addClickHandler(new ClickHandler() {

    @Override
    public void onClick(ClickEvent event) {
     getUiHandlers().onLinkClicked(NameTokens.livetable3);
    }
   });
  }

 private void initHandler() {
  page1.addClickHandler(new ClickHandler() {

   @Override
   public void onClick(ClickEvent event) {
    getUiHandlers().onLinkClicked(NameTokens.page1);
   }
  });
  page2.addClickHandler(new ClickHandler() {

   @Override
   public void onClick(ClickEvent event) {
    getUiHandlers().onLinkClicked(NameTokens.page2);
   }
  });
  page3.addClickHandler(new ClickHandler() {

   @Override
   public void onClick(ClickEvent event) {
    getUiHandlers().onLinkClicked(NameTokens.page3);
   }
  });
  home.addClickHandler(new ClickHandler() {

   @Override
   public void onClick(ClickEvent event) {
    getUiHandlers().onLinkClicked(NameTokens.home);
   }
  });
 }

 @Override
 public Widget asWidget() {
  return container;
 }

}