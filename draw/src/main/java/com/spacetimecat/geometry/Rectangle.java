package com.spacetimecat.geometry;

/**
 * <p>
 *     Immutable bounding rectangle.
 * </p>
 */
public interface Rectangle extends RectangleData
{
    /**
     * <p>
     *     Return a new rectangle as if {@code this} rectangle were moved by
     *     {@code rightward} to the right and {@code downward} to the bottom.
     * </p>
     *
     * @param rightward
     * how far the returned rectangle is moved rightwards from {@code this}
     *
     * @param downward
     * how far the returned rectangle is moved downwards from {@code this}
     *
     * @return a new instance
     */
    Rectangle translated (double rightward, double downward);

    Rectangle union (Rectangle that);

    static Rectangle empty ()
    {
        return new RectangleImpl(0.0, 0.0, 0.0, 0.0);
    }

    static Rectangle fromSize (double width, double height)
    {
        return new RectangleImpl(0, 0, width, height);
    }
}
