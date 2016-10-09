package com.spacetimecat.gui.menu.builder.swing;

import com.spacetimecat.gui.menu.builder.Menu;
import com.spacetimecat.gui.menu.builder.MenuBar;
import com.spacetimecat.gui.menu.builder.MenuItem;

import javax.swing.*;

final class SwingMenuBuilder implements Menu<JMenuBar>
{
    private final SwingMenuBarBuilder parent;
    private final JMenu delegate;

    SwingMenuBuilder (SwingMenuBarBuilder parent)
    {
        this.parent = parent;
        this.delegate = new JMenu();
    }

    @Override
    public MenuItem<JMenuBar> item ()
    {
        return new SwingMenuItemBuilder(this);
    }

    @Override
    public Menu<JMenuBar> text (String text)
    {
        delegate.setText(text);
        return this;
    }

    @Override
    public Menu<JMenuBar> mnemonic (char mnemonic)
    {
        delegate.setMnemonic(mnemonic);
        return this;
    }

    @Override
    public MenuBar<JMenuBar> end ()
    {
        parent.add(delegate);
        return parent;
    }

    void add (JMenuItem child)
    {
        delegate.add(child);
    }
}
