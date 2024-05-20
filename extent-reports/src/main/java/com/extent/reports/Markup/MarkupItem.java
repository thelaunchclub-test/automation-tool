package com.extent.reports.Markup;

import com.aventstack.extentreports.markuputils.Markup;

/**
 * Represents an individual item within a markup structure.
 * This interface extends the Markup interface, indicating that MarkupItems are part of a larger markup system.
 * MarkupItems typically encapsulate specific content or elements within a markup language, such as tags, elements, or nodes.
 * Implementing classes are expected to define the behavior and properties of these individual markup items.
 * <p>
 * Example scenarios where MarkupItems might be used include representing HTML tags, XML elements, or JSON key-value pairs.
 * By extending the Markup interface, MarkupItems inherit common functionality and characteristics defined by the broader markup system.
 * <p>
 * It's important to note that MarkupItem is a marker interface, meaning it doesn't define any additional methods or constants beyond those inherited from Markup.
 * Instead, it serves as a categorization mechanism, allowing for the identification and classification of individual items within the markup structure.
 * <p>
 * Developers extending or implementing MarkupItem should ensure that their classes appropriately represent and handle specific types of markup items.
 * Additionally, they should adhere to the conventions and standards established within the broader markup system to maintain consistency and interoperability.
 */
public interface MarkupItem extends Markup {

}