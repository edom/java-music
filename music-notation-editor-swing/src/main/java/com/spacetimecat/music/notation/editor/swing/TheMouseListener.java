package com.spacetimecat.music.notation.editor.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

final class TheMouseListener extends MouseAdapter
{
    private final TheCanvas canvas;

    TheMouseListener (TheCanvas canvas)
    {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked (MouseEvent e)
    {
        canvas.repaint();
    }
}
