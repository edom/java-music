package com.spacetimecat.music.notation.editor.swing;

import com.spacetimecat.gui.event.awt.AwtKeyboardHandler;
import com.spacetimecat.gui.menu.builder.swing.SwingMenuBarBuilder;
import com.spacetimecat.music.notation.editor.gui.DefaultKeyboardHandler;
import com.spacetimecat.music.notation.editor.gui.Dispatcher;
import com.spacetimecat.music.notation.editor.gui.TheDispatcher;
import com.spacetimecat.music.notation.editor.gui.TheMenuBar;
import com.spacetimecat.music.notation.editor.gui.EditorView;
import com.spacetimecat.music.notation.editor.gui.Ruler;
import com.spacetimecat.music.notation.editor.gui.TheEditorView;

import javax.swing.*;
import java.awt.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>
 *     The root window of the application.
 * </p>
 */
public final class TheRootFrame extends JFrame
{
    private static final long serialVersionUID = 0L;

    private TheRootFrame () {}

    public static JFrame create ()
    {
        final JFrame frame = new TheRootFrame();

        frame.setTitle("a music notation editor");
        frame.setMinimumSize(new Dimension(64, 64));
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);

        final Ruler ruler = AwtRuler.create();
        final EditorView editor = new TheEditorView(ruler, frame::repaint, frame::dispose);

        final TheCanvas canvas = TheCanvas.create(editor);
        frame.add(canvas);
        canvas.setBounds(0, 0, 640, 480);

        frame.pack();
        frame.setVisible(true);

        final Dispatcher dispatcher = new TheDispatcher(editor);

        frame.setJMenuBar(new TheMenuBar<>(new SwingMenuBarBuilder()).create(dispatcher));

        frame.addMouseListener(new TheMouseListener(canvas));
        frame.addKeyListener(AwtKeyboardHandler.toAwt(DefaultKeyboardHandler.create(dispatcher)));

        return frame;
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
