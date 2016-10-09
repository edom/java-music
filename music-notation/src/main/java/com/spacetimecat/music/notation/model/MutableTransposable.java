package com.spacetimecat.music.notation.model;

/**
 * <p>
 *     Something that is affected by transposition (translation in the pitch space).
 * </p>
 */
public interface MutableTransposable
{
    void transpose (int diatone, double accidental);
}
