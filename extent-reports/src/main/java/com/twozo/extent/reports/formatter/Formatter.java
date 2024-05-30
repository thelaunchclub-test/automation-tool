package com.twozo.extent.reports.formatter;

import com.aventstack.extentreports.markuputils.Markup;

/**
 * Represents an individual item within a format structure.
 * Extends the Markup interface, indicating that {@link Formatter} are part of a larger format system.
 * Typically, encapsulate specific content or elements within a format language, such as tags, elements, or nodes.
 * Implementing classes are expected to define the behavior and properties of these individual format items.
 * <p>
 * Example scenarios where {@link Formatter} might be used include representing HTML tags, XML elements, or JSON key-value pairs.
 * By extending the Markup interface, Formatter inherit common functionality and characteristics defined by the broader markup system.
 * <p>
 * It's important to note that MarkupItem is a marker interface, meaning it doesn't define any additional methods or constants beyond those inherited from Markup.
 * Instead, it serves as a categorization mechanism, allowing for the identification and classification of individual items within the markup structure.
 * <p>
 * Developers extending or implementing MarkupItem should ensure that their classes appropriately represent and handle specific types of markup items.
 * Additionally, they should adhere to the conventions and standards established within the broader markup system to maintain consistency and interoperability.
 *
 * @version 1.0
 * @Author Navin Jones
 * @see Markup
 */
public interface Formatter extends Markup {
}