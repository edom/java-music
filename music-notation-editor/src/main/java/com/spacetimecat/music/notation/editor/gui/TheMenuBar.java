package com.spacetimecat.music.notation.editor.gui;

import com.spacetimecat.gui.menu.builder.MenuBar;

/**
 * <p>
 *     The menu bar of the application.
 * </p>
 *
 * @param <ActualType> the implementation type
 */
public final class TheMenuBar<ActualType>
{
    private final MenuBar<ActualType> builder;

    public TheMenuBar (MenuBar<ActualType> builder)
    {
        this.builder = builder;
    }

    public ActualType create (Dispatcher dispatcher)
    {
        return builder
            .menu().text("File").mnemonic('F')
                .item().text("What").mnemonic('W').end()
                .item().text("Exit").mnemonic('X').action(dispatcher::quit).end()
            .end()
        .build();
    }
}
