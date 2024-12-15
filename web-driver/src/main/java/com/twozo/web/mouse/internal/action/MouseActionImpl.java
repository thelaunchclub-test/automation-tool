package com.twozo.web.mouse.internal.action;

import com.twozo.web.mouse.service.action.MouseAction;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.interactions.Action;

/**
 * <p>
 * Represents a mouse action to be performed on a web page.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * mouseAction.perform();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see MouseAction
 */
@NonNull
@AllArgsConstructor
public class MouseActionImpl implements MouseAction {

    private final Action action;

    /**
     * {@inheritDoc}
     */
    @Override
    public void perform() {
        action.perform();
    }
}
