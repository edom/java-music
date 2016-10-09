package com.spacetimecat.drawer;

/**
 * <p>
 *     Stateful mutable graphics context such as color, font, transform.
 * </p>
 */
public interface Context
{
    /**
     * <p>
     *     Set the font face.
     * </p>
     *
     * @param name name of the font
     */
    void setFont (String name);

    /**
     * <p>
     *     Set the font size in points (not pixels).
     * </p>
     *
     * @param point the font size
     */
    void setFontSizePoint (double point);

    /**
     * <p>
     *     Add a translation to the current transform;
     *     if {@code rightward} is positive,
     *     everything will move to the right.
     * </p>
     *
     * @param rightward
     * how far to move everything toward the right side
     *
     * @param downward
     * how far to move everything toward the bottom side
     */
    void translate (double rightward, double downward);
}
