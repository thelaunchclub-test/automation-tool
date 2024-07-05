package com.twozo.extent.report.test.internal.formatter.codeblock;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.templating.FreemarkerTemplate;

import com.google.gson.Gson;

import com.twozo.extent.report.test.internal.formatter.fields.CodeFields;
import com.twozo.extent.report.test.model.CodeLanguage;
import com.twozo.extent.report.test.service.Formatter;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Provides functionality to format code as plain text or as JSON, based on the specified templates
 * and language.
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * CodeFormatter formatter = CodeFormatter.builder()
 *     .templateCodeBlock(new Template("plain text template"));
 *
 * String formattedCode = formatter.format();
 * }</pre>
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see Formatter
 */
@Builder
@Getter
@Setter
public final class CodeFormatter implements Formatter {

    public static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);
    public static final FreemarkerTemplate FREEMARKER_TEMPLATE = new FreemarkerTemplate(ExtentReports.class, "markup/", "UTF-8");

    private transient Template templateCodeBlock;
    private transient Template templateCodeBlockJson;
    private transient Object jsonObject;
    private String[] codeArray;
    private CodeLanguage codeLanguage;

    /**
     * <p>
     * Sets up the templates for formatting code blocks.
     * </p>
     */
    private void setupTemplate() {

        if (Objects.isNull(templateCodeBlock) || Objects.isNull(templateCodeBlockJson)) {

            try {
                templateCodeBlock = FREEMARKER_TEMPLATE.createTemplate(CodeFields.DEFAULT_TEMPLATE_FILE_NAME);
                templateCodeBlockJson = FREEMARKER_TEMPLATE.createTemplate(CodeFields.JSON_TEMPLATE_FILE_NAME);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * <p>
     * Generates the format representation of the code block.
     * </p>
     *
     * @return The HTML format representation of the code block.
     */
    @Override
    public String getMarkup() {
        setupTemplate();

        if (Objects.isNull(jsonObject) && Objects.isNull(codeArray)) {
            return CodeFields.EMPTY_STRING;
        }

        if (Objects.nonNull(jsonObject)) {
            codeArray = new String[]{new Gson().toJson(jsonObject)}; //TODO After merging PetchiMuthu's JSON code, please share the updated version here.
        }

        int indexes = 0;
        Template template = templateCodeBlock;

        if (codeLanguage == CodeLanguage.JSON) {
            indexes = ATOMIC_INTEGER.getAndIncrement();
            template = templateCodeBlockJson;
        }

        final Map<String, Object> templateDataMap = new HashMap<>();

        templateDataMap.put(CodeFields.CODE, codeArray);
        templateDataMap.put(CodeFields.INDEX, indexes);

        try {
            return FREEMARKER_TEMPLATE.getSource(template, templateDataMap);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}