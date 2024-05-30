package com.twozo.extent.reports.formatter.codeblock;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.templating.FreemarkerTemplate;

import com.google.gson.Gson;

import com.twozo.extent.reports.formatter.Formatter;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import lombok.Builder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a block element in markup, implementing the {@link Formatter}.
 * Provides functionality for generating formatter for code blocks, utilizing Freemarker templates.
 * <p>
 * The class utilizes Lombok annotation (@Builder) to
 * automatically generate a builder representation, reducing boilerplate code and improving code readability.
 *
 * @version 1.0
 * @Author Navin Jones
 * @see Formatter
 */
@Builder
public final class CodeFormatter implements Formatter {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);
    private static final FreemarkerTemplate FREEMARKER_TEMPLATE = new FreemarkerTemplate(ExtentReports.class, "markup/", "UTF-8");
    private static Template codeBlock;
    private static Template codeBlockJson;
    private String[] codeArray;
    private CodeLanguage lang;
    private Object jsonObject;

    static {
        try {
            codeBlock = FREEMARKER_TEMPLATE.createTemplate("codeblock.ftl");
            codeBlockJson = FREEMARKER_TEMPLATE.createTemplate("codeblock.json.ftl");
            System.out.println("Templates loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load templates.");
        }
    }

    /**
     * Generates the markup representation of the code block.
     * This method overrides the getMarkup() method defined in the Mark interface.
     *
     * @return The HTML markup representation of the code block.
     */
    @Override
    public String getMarkup() {

        if (Objects.isNull(jsonObject) && Objects.isNull(codeArray)) {
            return "";
        }

        if (Objects.nonNull(jsonObject)) {
            codeArray = new String[]{new Gson().toJson(jsonObject)};
        }

        int index = 0;
        Template template = codeBlock;

        if (lang == CodeLanguage.JSON) {
            index = ATOMIC_INTEGER.getAndIncrement();
            template = codeBlockJson;
        }

        final Map<String, Object> map = new HashMap<>();
        map.put("code", codeArray);
        map.put("index", index);

        try {
            return FREEMARKER_TEMPLATE.getSource(template, map);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}