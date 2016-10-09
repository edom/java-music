package com.spacetimecat.gui.event.awt;

import com.spacetimecat.gui.event.KeyPress;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public final class AwtKeyPress
{
    private AwtKeyPress () {}

    public static KeyPress from (KeyEvent delegate)
    {
        final boolean ctrl = (delegate.getModifiers() & InputEvent.CTRL_DOWN_MASK) != 0;
        final boolean alt = (delegate.getModifiers() & InputEvent.ALT_DOWN_MASK) != 0;
        final boolean shift = (delegate.getModifiers() & InputEvent.SHIFT_DOWN_MASK) != 0;
        return KeyPress.create(delegate.getKeyCode(), ctrl, alt, shift);
    }
}
