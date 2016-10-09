package com.spacetimecat.gui.event;

final class KeyActionImpl implements KeyAction
{
    private final KeyPress shortcut;
    private final String title;
    private final Runnable action;

    KeyActionImpl (KeyPress shortcut, String title, Runnable action)
    {
        this.shortcut = shortcut;
        this.title = title;
        this.action = action;
    }

    @Override
    public void perform ()
    {
        action.run();
    }

    @Override
    public KeyPress getKeyPress ()
    {
        return shortcut;
    }

    @Override
    public String getTitle ()
    {
        return title;
    }
}
