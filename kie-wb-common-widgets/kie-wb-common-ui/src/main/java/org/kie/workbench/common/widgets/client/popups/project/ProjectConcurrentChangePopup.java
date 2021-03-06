/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.widgets.client.popups.project;

import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import org.kie.workbench.common.widgets.client.resources.i18n.ProjectConcurrentChangePopupConstants;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.common.AbstractConcurrentChangePopup;
import org.uberfire.client.resources.i18n.CommonConstants;
import org.uberfire.mvp.Command;
import org.uberfire.security.Identity;

public class ProjectConcurrentChangePopup extends AbstractConcurrentChangePopup {


    private ProjectConcurrentChangePopup( final String content,
                                   final Command onIgnore,
                                   final Command onAction,
                                   final String buttonText ) {
        super(content, onIgnore, onAction, buttonText);
    }

    private ProjectConcurrentChangePopup( final String content,
                                   final Command onIgnore,
                                   final Command onReOpen ) {
        this(content, onIgnore, onReOpen, CommonConstants.INSTANCE.ReOpen());
    }

    private ProjectConcurrentChangePopup( final String content,
                                   final Command onForceSave,
                                   final Command onIgnore,
                                   final Command onReOpen ) {
        super(content, onForceSave, onIgnore, onReOpen);
    }

    public static ProjectConcurrentChangePopup newConcurrentUpdate( final Path project,
                                                             final Identity identity,
                                                             final Command onForceSave,
                                                             final Command onCancel,
                                                             final Command onReOpen ) {

        final String message = ProjectConcurrentChangePopupConstants.INSTANCE.ConcurrentUpdate( identity != null ? SafeHtmlUtils.htmlEscape(identity.getName() != null ? identity.getName() : "") : null, project.toURI() );

        return new ProjectConcurrentChangePopup( message, onForceSave, onCancel, onReOpen );
    }

    public static ProjectConcurrentChangePopup newConcurrentChange( final Path project,
                                                             final Identity identity,
                                                             final Command onIgnore,
                                                             final Command onReOpen ) {
        final String message = ProjectConcurrentChangePopupConstants.INSTANCE.ConcurrentChange( identity != null ? SafeHtmlUtils.htmlEscape(identity.getName() != null ? identity.getName() : "") : null, project.toURI() );
        return new ProjectConcurrentChangePopup( message, onIgnore, onReOpen );
    }

}