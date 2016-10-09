package com.spacetimecat.gui.event;

public interface KeyAction extends KeyboardShortcut
{
    void perform ();

    static KeyAction create (KeyPress combination, String title, Runnable action)
    {
        return new KeyActionImpl(combination, title, action);
    }
}
