package com.spacetimecat.gui.menu.builder;

public interface MenuBar<MenuBarType>
{
    Menu<MenuBarType> menu ();

    /**
     * <p>
     *     After this is called, the builder should not be used anymore.
     * </p>
     *
     * @return a menu bar implementation
     */
    MenuBarType build ();
}
