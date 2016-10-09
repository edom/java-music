package com.spacetimecat.music.notation.editor.gui;

import com.spacetimecat.drawable.DrawFunction;
import com.spacetimecat.music.notation.view.StaffView;

public interface EditorView extends DrawFunction
{
    StaffView getStaff (int index);

    void addStaff ();

    void export ();

    void quit ();

    void repaint ();
}
