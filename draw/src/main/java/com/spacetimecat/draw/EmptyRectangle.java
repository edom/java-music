package com.spacetimecat.draw;

/**
 * <p>
 *     A {@link Rectangle} that is all zeroes.
 * </p>
 */
public final class EmptyRectangle implements Rectangle
{
    EmptyRectangle () {}

    @Override
    public double leftX ()
    {
        return 0.0;
    }

    @Override
    public double topY ()
    {
        return 0.0;
    }

    @Override
    public double rightX ()
    {
        return 0.0;
    }

    @Override
    public double bottomY ()
    {
        return 0.0;
    }

    @Override
    public double width ()
    {
        return 0.0;
    }

    @Override
    public double height ()
    {
        return 0.0;
    }

    @Override
    public Rectangle translated (double rightward, double downward)
    {
        // TODO create TranslatedRectangle class
        throw new UnsupportedOperationException();
    }

    @Override
    public Rectangle union (Rectangle that)
    {
        return that;
    }
}
