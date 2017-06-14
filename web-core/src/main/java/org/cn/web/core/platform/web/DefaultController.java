package org.cn.web.core.platform.web;

import org.cn.web.core.platform.context.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.inject.Inject;
import java.util.Locale;

public class DefaultController {
    protected Messages messages;

    protected String getMessage(String key, Object... args) {
        LocaleContextHolder.setLocale(Locale.US);
        Locale locale = LocaleContextHolder.getLocale();
        return messages.getMessage(key, args, locale);
    }

    @Inject
    public void setMessages(Messages messages) {
        this.messages = messages;
    }
}
