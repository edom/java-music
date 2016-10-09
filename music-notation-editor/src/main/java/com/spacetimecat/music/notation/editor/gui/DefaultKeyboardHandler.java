package com.spacetimecat.music.notation.editor.gui;

import com.spacetimecat.gui.event.KeyAction;
import com.spacetimecat.gui.event.KeyPress;
import com.spacetimecat.gui.event.KeyboardHandler;
import com.spacetimecat.music.notation.model.MutableNoteModelImpl;

import java.awt.event.KeyEvent;

public final class DefaultKeyboardHandler
{
    private DefaultKeyboardHandler () {}

    public static KeyboardHandler create (Dispatcher dispatcher)
    {
        return KeyboardHandler.fromArray(
            insertNote('C', 0, dispatcher)
            , insertNote('D', 1, dispatcher)
            , insertNote('E', 2, dispatcher)
            , insertNote('F', 3, dispatcher)
            , insertNote('G', 4, dispatcher)
            , insertNote('A', 5, dispatcher)
            , insertNote('B', 6, dispatcher)
            , KeyPress.just('R').createAction("Repaint", dispatcher::repaint)
            , KeyPress.just('S').createAction("Add staff", dispatcher::addStaff)
            , KeyPress.just('H').createAction("Add G clef", dispatcher::addClefG)
            , KeyPress.just('X').createAction("Export", dispatcher::export)
            , KeyPress.just(KeyEvent.VK_BACK_SPACE).createAction("Backspace", dispatcher::backspace)
        );
    }

    static KeyAction insertNote (char modifiee, int diatone, Dispatcher consumer)
    {
        final Runnable action = () -> consumer.addNote(new MutableNoteModelImpl(diatone, 8));
        final String title = String.format("Insert note %c", modifiee);
        return KeyPress.just(modifiee).createAction(title, action);
    }
}
