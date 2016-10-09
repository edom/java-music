package com.spacetimecat.music.notation.view;

import com.spacetimecat.drawable.DrawFunction;
import com.spacetimecat.drawable.Drawable;
import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.music.notation.model.MutableNoteModelImpl;
import com.spacetimecat.music.notation.model.NoteModel;

import java.util.function.Supplier;

public class NoteDrawFunction implements DrawFunction
{
    private final NoteModel note;
    private final Supplier<Double> getSpacing;

    public NoteDrawFunction (NoteModel note, Supplier<Double> getSpacing)
    {
        this.note = note;
        this.getSpacing = getSpacing;
    }

    @Override
    public void draw (Drawer g)
    {
        final int pitch = note.getPitch();
        final int gclefTopLinePitch = new MutableNoteModelImpl(4, 4).getPitch();
        final int hspOffset = pitch - gclefTopLinePitch;
        final String quarterNotehead = "\uE0A4";
        Drawable.string(quarterNotehead).translated(0, hspOffset * getSpacing.get() / 2).draw(g);
    }
}
