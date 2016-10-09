package com.spacetimecat.music.notation.editor.gui;

import com.spacetimecat.music.notation.model.MutableNoteModel;

/**
 * <p>
 *     React to keyboard events;
 *     things that can be done using the keyboard.
 * </p>
 */
public interface Dispatcher
{
    /**
     * <p>
     *     Insert a note at the cursor.
     * </p>
     *
     * @param note the note
     */
    void addNote (MutableNoteModel note);

    void addClefG ();

    void addStaff ();

    void export ();

    void repaint ();

    void backspace ();

    void quit ();
}
