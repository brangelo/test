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

import com.fhoster.test.client.presenter.PageOnePresenter;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class PageOneView extends ViewImpl implements PageOnePresenter.MyView {
    public interface Binder extends UiBinder<Widget, PageOneView> {
    }

    @Inject
    public PageOneView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
