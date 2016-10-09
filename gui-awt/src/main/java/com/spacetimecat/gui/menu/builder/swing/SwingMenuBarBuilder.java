package com.spacetimecat.gui.menu.builder.swing;

import com.spacetimecat.gui.menu.builder.Menu;
import com.spacetimecat.gui.menu.builder.MenuBar;

import javax.swing.*;

public class SwingMenuBarBuilder implements MenuBar<JMenuBar>
{
    private final JMenuBar delegate = new JMenuBar();

    @Override
    public Menu<JMenuBar> menu ()
    {
        return new SwingMenuBuilder(this);
    }

    @Override
    public JMenuBar build ()
    {
        return delegate;
    }

    void add (JMenu child)
    {
        delegate.add(child);
    }
}
