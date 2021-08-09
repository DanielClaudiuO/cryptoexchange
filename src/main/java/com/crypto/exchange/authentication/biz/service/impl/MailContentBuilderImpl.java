package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.service.MailContentBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class MailContentBuilderImpl implements MailContentBuilder {

    private final TemplateEngine templateEngine;

    public String build(String message, String link) {
        var context = new Context();
        context.setVariable("message", message);
        context.setVariable("link", link);
        return templateEngine.process("mailTemplate", context);
    }
}