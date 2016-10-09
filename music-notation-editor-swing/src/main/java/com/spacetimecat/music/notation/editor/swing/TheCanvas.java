package com.spacetimecat.music.notation.editor.swing;

import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.drawer.awt.AwtDrawer;
import com.spacetimecat.music.notation.editor.gui.EditorView;

import javax.swing.*;
import java.awt.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

final class TheCanvas extends JComponent
{
    private static final long serialVersionUID = 0L;

    private final EditorView editor;

    private TheCanvas (EditorView editor)
    {
        this.editor = editor;
    }

    static TheCanvas create (EditorView editor)
    {
        final TheCanvas canvas = new TheCanvas(editor);
        canvas.setLayout(null);
        canvas.setPreferredSize(new Dimension(640, 480));
        canvas.setMinimumSize(new Dimension(640, 480));
        canvas.setDoubleBuffered(true);
        return canvas;
    }

    @Override
    public void paint (Graphics g_)
    {
        super.paint(g_);
        final Graphics2D g = (Graphics2D) g_;
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        try (final Drawer cmds = AwtDrawer.copyOf(g))
        {
            editor.draw(cmds);
        }
    }

    private void readObject (ObjectInputStream ignored)
    {
        throw new UnsupportedOperationException("readObject");
    }

    private void writeObject (ObjectOutputStream ignored)
    {
        throw new UnsupportedOperationException("writeObject");
    }
}
