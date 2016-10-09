package com.spacetimecat.gui.event.awt;

import com.spacetimecat.gui.event.KeyboardHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <p>
 *     This adapts a {@link KeyboardHandler} into a {@link KeyAdapter}
 *     so that you can use a {@link KeyboardHandler} with AWT.
 * </p>
 */
public final class AwtKeyboardHandler extends KeyAdapter
{
    private final KeyboardHandler delegate;

    private AwtKeyboardHandler (KeyboardHandler delegate)
    {
        this.delegate = delegate;
    }

    @Override
    public void keyPressed (KeyEvent e)
    {
        delegate.accept(AwtKeyPress.from(e));
    }

    public static KeyAdapter toAwt (KeyboardHandler delegate)
    {
        return new AwtKeyboardHandler(delegate);
    }
}
