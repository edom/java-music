package com.spacetimecat.music.notation.layout;

/**
 * <p>
 *     Thing inside a staff.
 * </p>
 */
public interface StaffContent
{
    /**
     * Pitch-axis coordinate of the thing
     */
    int pitch ();

    /**
     * Time-axis coordinate of the thing
     */
    int time ();
}
