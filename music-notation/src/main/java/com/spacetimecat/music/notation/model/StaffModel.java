package com.spacetimecat.music.notation.model;

/**
 * <p>
 *     A two-dimensional drawing where one axis represents time
 *     and the other axis represents pitch.
 * </p>
 */
public interface StaffModel
{
    /**
     * <p>
     *     Number of lines in the staff; for example, in Western musical notation,
     *     a melody-containing staff has 5 lines.
     * </p>
     *
     * @return number of lines in the staff
     */
    int getLineCount ();
}
