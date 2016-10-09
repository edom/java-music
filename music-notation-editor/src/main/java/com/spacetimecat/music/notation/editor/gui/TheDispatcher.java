package com.spacetimecat.music.notation.editor.gui;

import com.spacetimecat.music.notation.model.MutableNoteModel;
import com.spacetimecat.music.notation.model.ClefGModelImpl;

public final class TheDispatcher implements Dispatcher
{
    private final EditorView editor;

    public TheDispatcher (EditorView editor)
    {
        this.editor = editor;
    }

    @Override
    public void addNote (MutableNoteModel note)
    {
        editor.getStaff(0).addNote(note);
        repaint();
    }

    @Override
    public void addClefG ()
    {
        editor.getStaff(0).addClef(new ClefGModelImpl());
        repaint();
    }

    @Override
    public void addStaff ()
    {
        editor.addStaff();
        repaint();
    }

    @Override
    public void export ()
    {
        editor.export();
    }

    @Override
    public void backspace ()
    {
        editor.getStaff(0).backspace();
        repaint();
    }

    @Override
    public void quit ()
    {
        editor.quit();
    }

    @Override
    public void repaint ()
    {
        editor.repaint();
    }
}
