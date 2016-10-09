package com.spacetimecat.gui.menu.builder.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;

final class ActionFromRunnable extends AbstractAction
{
    private final Runnable action;

    ActionFromRunnable (String text, Runnable action)
    {
        super(text);
        this.action = action;
    }

    @Override
    public void actionPerformed (ActionEvent e)
    {
        action.run();
    }
}
