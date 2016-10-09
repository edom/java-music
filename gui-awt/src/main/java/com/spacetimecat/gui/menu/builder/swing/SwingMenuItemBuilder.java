package com.spacetimecat.gui.menu.builder.swing;

import com.spacetimecat.gui.menu.builder.Menu;
import com.spacetimecat.gui.menu.builder.MenuItem;

import javax.swing.*;

final class SwingMenuItemBuilder implements MenuItem<JMenuBar>
{
    private final SwingMenuBuilder parent;
    private String text = "";
    private Runnable action = () -> {};
    private Character mnemonic;

    SwingMenuItemBuilder (SwingMenuBuilder parent)
    {
        this.parent = parent;
    }

    @Override
    public MenuItem<JMenuBar> text (String text)
    {
        this.text = text;
        return this;
    }

    @Override
    public MenuItem<JMenuBar> action (Runnable action)
    {
        this.action = action;
        return this;
    }

    @Override
    public MenuItem<JMenuBar> mnemonic (char mnemonic)
    {
        this.mnemonic = mnemonic;
        return this;
    }

    @Override
    public Menu<JMenuBar> end ()
    {
        final JMenuItem child = new JMenuItem();
        child.setAction(new ActionFromRunnable(text, action));
        if (mnemonic != null) { child.setMnemonic(mnemonic); }
        parent.add(child);
        return parent;
    }
}
