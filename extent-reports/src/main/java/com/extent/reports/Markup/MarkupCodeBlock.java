package com.extent.reports.Markup;

import com.aventstack.extentreports.templating.FreemarkerTemplate;

import com.extent.reports.extent.AbstractExtentReporter;

import com.google.gson.Gson;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a block element in markup, implementing the Mark interface.
 * This class provides functionality for generating markup for code blocks, utilizing Freemarker templates.
 * <p>
 * The class utilizes Lombok annotations (@Getter, @Builder, @AllArgsConstructor, @ToString) to
 * automatically generate getter methods, a builder, a constructor with all fields, and a toString representation,
 * reducing boilerplate code and improving code readability.
 */
@Getter
@Builder
@AllArgsConstructor
@ToString
public class MarkupCodeBlock implements MarkupItem {

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    protected static final FreemarkerTemplate freemarkerTemplate = new FreemarkerTemplate(AbstractExtentReporter.class, "markup/", "UTF-8");

    private static Template codeBlock;
    private static Template codeBlockJson;
    private String[] codeArray;
    private CodeLanguage lang;
    private Object jsonObject;

    /**
     * Generates the markup representation of the code block.
     * This method overrides the getMarkup() method defined in the Mark interface.
     *
     * @return The HTML markup representation of the code block.
     */
    @Override
    public String getMarkup() {

        if (jsonObject == null && codeArray == null) {
            return "";
        }

        if (jsonObject != null) {
            codeArray = new String[]{new Gson().toJson(jsonObject)};
        }

        int index = 0;
        Template template = codeBlock;

        if (lang == CodeLanguage.JSON) {
            index = atomicInteger.getAndIncrement();
            template = codeBlockJson;
        }

        final Map<String, Object> map = new HashMap<>();
        map.put("code", codeArray);
        map.put("index", index);

        try {

            return freemarkerTemplate.getSource(template, map);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}