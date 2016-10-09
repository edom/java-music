package com.spacetimecat.gui.menu.builder;

public interface Menu<MenuBarType>
{
    MenuItem<MenuBarType> item ();

    Menu<MenuBarType> text (String text);

    Menu<MenuBarType> mnemonic (char mnemonic);

    /**
     * <p>
     *     Return to the parent menu bar builder.
     * </p>
     *
     * @return the parent
     */
    MenuBar<MenuBarType> end ();
}
