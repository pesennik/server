package com.github.pesennik.util;

import org.apache.commons.io.IOUtils;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.protocol.http.WebApplication;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebUtils {

    private static final Logger log = LoggerFactory.getLogger(WebUtils.class);

    public static void focus(@NotNull AjaxRequestTarget target, @NotNull Component component) {
        String markupId = component.getMarkupId();
        if (TextUtils.isEmpty(markupId)) {
            log.error("Component has no markup id: " + component);
            return;
        }
        focus(target, markupId);
    }

    public static void focus(@NotNull AjaxRequestTarget target, @NotNull String id) {
        target.appendJavaScript("$('#" + id + "').focus();");
    }

    public static void addFocusOnEnter(@NotNull Component keypressComponent, @NotNull Component component) {
        String markupId = component.getMarkupId();
        if (TextUtils.isEmpty(markupId)) {
            log.error("Component has no markup id: " + component);
            return;
        }
        addFocusOnEnter(keypressComponent, markupId);
    }

    public static void addFocusOnEnter(@NotNull Component keypressComponent, @NotNull String focusedId) {
        keypressComponent.add(new AttributeAppender("onkeypress", "$site.Utils.focusOnEnter(event, '#" + focusedId + "');"));
    }

    public static void addClickOnEnter(@NotNull Component keypressComponent, @NotNull Component component) {
        String markupId = component.getMarkupId();
        if (TextUtils.isEmpty(markupId)) {
            log.error("Component has no markup id: " + component);
            return;
        }
        addClickOnEnter(keypressComponent, markupId);

    }

    public static void addClickOnEnter(@NotNull Component keypressComponent, @NotNull String clickedId) {
        keypressComponent.add(new AttributeAppender("onkeypress", "$site.Utils.clickOnEnter(event, '#" + clickedId + "');"));
    }

    @NotNull
    public static byte[] getWebInfResource(@NotNull String path) throws Exception {
        return IOUtils.toByteArray(WebApplication.get().getServletContext().getResource(path));
    }

    public static void scrollTo(@NotNull Component c, @NotNull AjaxRequestTarget target) {
        target.appendJavaScript("$site.Utils.scrollToBlock('#" + c.getMarkupId() + "');");
    }

}
