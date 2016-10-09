package com.spacetimecat.music.notation.model;

import java.util.ArrayList;
import java.util.List;

final class MutableStaffModelImpl implements MutableStaffModel
{
    private final List<MutableTransposable> transposables = new ArrayList<>(4);

    private final int lineCount;

    MutableStaffModelImpl (int lineCount)
    {
        if (lineCount <= 0) { throw new IllegalArgumentException("lineCount <= 0"); }
        this.lineCount = lineCount;
    }

    @Override
    public void addNote (MutableNoteModel note)
    {
        if (note == null) { throw new NullPointerException("note"); }
        transposables.add(note);
    }

    @Override
    public void addClef (ClefModel clef)
    {
    }

    @Override
    public int getLineCount ()
    {
        return lineCount;
    }

    @Override
    public void transpose (int diatone, double accidental)
    {
        transposables.forEach(item -> item.transpose(diatone, accidental));
    }
}
