/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.fhoster.test.client.view;

import com.fhoster.test.client.GreetingService;
import com.fhoster.test.client.GreetingServiceAsync;
import com.fhoster.test.client.presenter.PageThreePresenter;
import com.fhoster.test.shared.FieldVerifier;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class PageThreeView extends ViewImpl implements PageThreePresenter.MyView {

	FlowPanel container;
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	@Inject
	public PageThreeView() {
		
		container = new FlowPanel();

		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		container.add(nameField);
		container.add(sendButton);
		container.add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		
		
		
		
		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});
		
		// Create a handler for the sendButton and nameField
		 		class MyHandler implements ClickHandler, KeyUpHandler {
		 			/**
		 			 * Fired when the user clicks on the sendButton.
		 			 */
		 			public void onClick(ClickEvent event) {
		 				sendNameToServer();
		 			}

		 			/**
		 			 * Fired when the user types in the nameField.
		 			 */
		 			public void onKeyUp(KeyUpEvent event) {
		 				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
		 					sendNameToServer();
		 				}
		 			}

		 			/**
		 			 * Send the name from the nameField to the server and wait for a response.
		 			 */
		 			private void sendNameToServer() {
		 				// First, we validate the input.
		 				errorLabel.setText("");
		 				String textToServer = nameField.getText();
		 				if (!FieldVerifier.isValidName(textToServer)) {
		 					errorLabel.setText("Please enter at least four characters");
		 					return;
		 				}

		 				// Then, we send the input to the server.
		 				sendButton.setEnabled(false);
		 				textToServerLabel.setText(textToServer);
		 				serverResponseLabel.setText("");
		 				greetingService.greetServer(textToServer,
		 						new AsyncCallback<String>() {
		 							public void onFailure(Throwable caught) {
		 								// Show the RPC error message to the user
		 								dialogBox
		 										.setText("Remote Procedure Call - Failure");
		 								serverResponseLabel
		 										.addStyleName("serverResponseLabelError");
		 								serverResponseLabel.setHTML(SERVER_ERROR);
		 								dialogBox.center();
		 								closeButton.setFocus(true);
		 							}

		 							public void onSuccess(String result) {
		 								dialogBox.setText("Remote Procedure Call");
		 								serverResponseLabel
		 										.removeStyleName("serverResponseLabelError");
		 								serverResponseLabel.setHTML(result);
		 								dialogBox.center();
		 								closeButton.setFocus(true);
		 							}
		 						});
		 			}
		 		}

		 		// Add a handler to send the name to the server
		 		MyHandler handler = new MyHandler();
		 		sendButton.addClickHandler(handler);
		 		nameField.addKeyUpHandler(handler);
		 		
	}
    
	@Override
	public Widget asWidget() {
		return container;
	}
}