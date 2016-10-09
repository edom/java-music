package com.spacetimecat.music.notation.model;

public interface MutableNoteModel extends NoteModel, MutableTransposable
{
    void setDiatone (int diatone);

    void setOctave (int octave);
}
