package com.spacetimecat.music.notation.model;

public interface NoteModel
{
    int getDiatone ();

    int getOctave ();

    int getPitch ();

    /**
     * <p>
     *     The number of sharps; negative means flat.
     * </p>
     *
     * @return see description
     */
    double getAccidental ();
}
