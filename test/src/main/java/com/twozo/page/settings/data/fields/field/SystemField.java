package com.twozo.page.settings.data.fields.field;

import com.twozo.web.element.service.WebPageElement;

public record SystemField(WebPageElement dragAndDropIcon, WebPageElement fieldName, WebPageElement fieldType,
        WebPageElement addViewCheckbox, WebPageElement requiredCheckbox, WebPageElement hideIcon) {
        }