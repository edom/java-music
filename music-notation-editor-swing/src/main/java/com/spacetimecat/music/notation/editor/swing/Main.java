package com.spacetimecat.music.notation.editor.swing;

import javax.swing.*;

/**
 * <p>
 *     Entry point.
 * </p>
 */
public final class Main
{
    private Main () {}

    public static void main (String... args)
    {
        SwingUtilities.invokeLater(TheRootFrame::create);
    }
}
