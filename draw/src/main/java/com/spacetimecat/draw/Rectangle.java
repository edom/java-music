package com.spacetimecat.draw;

/**
 * <p>
 *     Bounding rectangle.
 * </p>
 */
public interface Rectangle
{
    double leftX ();

    double topY ();

    double rightX ();

    double bottomY ();

    double width ();

    double height ();

    Rectangle translated (double rightward, double downward);

    Rectangle union (Rectangle that);

    static Rectangle empty ()
    {
        return new EmptyRectangle();
    }
}
