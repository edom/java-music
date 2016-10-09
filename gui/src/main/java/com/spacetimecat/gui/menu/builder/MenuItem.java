package com.spacetimecat.gui.menu.builder;

public interface MenuItem<MenuBarType>
{
    MenuItem<MenuBarType> text (String text);

    MenuItem<MenuBarType> action (Runnable action);

    MenuItem<MenuBarType> mnemonic (char mnemonic);

    Menu<MenuBarType> end ();
}
