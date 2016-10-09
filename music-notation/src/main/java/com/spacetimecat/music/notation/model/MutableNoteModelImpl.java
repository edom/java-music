package com.spacetimecat.music.notation.model;

/**
 * <p>
 *     Thing inside a staff.
 * </p>
 */
public final class MutableNoteModelImpl implements MutableNoteModel
{
    private int diatone;
    private int octave;
    private double accidental;

    public MutableNoteModelImpl ()
    {
    }

    public MutableNoteModelImpl (int diatone, int octave)
    {
        this.diatone = diatone;
        this.octave = octave;
    }

    @Override
    public int getDiatone ()
    {
        return diatone;
    }

    @Override
    public void setDiatone (int diatone)
    {
        if (diatone < 0) { throw new IllegalArgumentException("diatone < 0"); }
        this.diatone = diatone;
    }

    @Override
    public int getOctave ()
    {
        return octave;
    }

    @Override
    public void setOctave (int octave)
    {
        this.octave = octave;
    }

    /**
     * Pitch-axis coordinate of the thing
     */
    @Override
    public int getPitch ()
    {
        return 7 * octave + diatone; // XXX
    }

    @Override
    public double getAccidental ()
    {
        return accidental;
    }

    /**
     * Time-axis coordinate of the thing
     */
    public int time ()
    {
        return 0; // XXX
    }

    @Override
    public void transpose (int diatone, double accidental)
    {
        this.diatone += diatone;
        this.accidental += accidental;
        normalize();
    }

    private void normalize ()
    {
        // If you want to replace this with integer division and modulus,
        // make sure you know how they deal with negative operands,
        // but this should be fast enough for normal usage anyway.
        while (diatone < 0)
        {
            diatone += 7;
            --octave;
        }
        while (diatone >= 7)
        {
            diatone -= 7;
            ++octave;
        }
        assert diatone >= 0;
        assert diatone < 7;
    }
}
