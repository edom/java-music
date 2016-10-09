package com.spacetimecat.drawer.awt;

import com.spacetimecat.geometry.Rectangle;

import java.awt.geom.Rectangle2D;

/**
 * <p>
 *     A {@link Rectangle} that uses AWT {@link Rectangle2D}.
 * </p>
 */
public final class AwtRectangle implements Rectangle
{
    private final Rectangle2D delegate;

    private AwtRectangle (Rectangle2D delegate)
    {
        this.delegate = (Rectangle2D) delegate.clone();
    }

    public static Rectangle from (Rectangle2D copy)
    {
        return new AwtRectangle(copy);
    }

    public static Rectangle fromXywh (double left, double top, double width, double height)
    {
        return new AwtRectangle(new Rectangle2D.Double(left, top, width, height));
    }

    public static Rectangle fromSize (double width, double height)
    {
        return fromXywh(0, 0, width, height);
    }

    @Override
    public double leftX ()
    {
        return delegate.getX();
    }

    @Override
    public double topY ()
    {
        return delegate.getY();
    }

    @Override
    public double rightX ()
    {
        return delegate.getMaxX();
    }

    @Override
    public double bottomY ()
    {
        return delegate.getMaxY();
    }

    @Override
    public double width ()
    {
        return delegate.getWidth();
    }

    @Override
    public double height ()
    {
        return delegate.getHeight();
    }

    @Override
    public Rectangle translated (double rightward, double downward)
    {
        return fromXywh
        (
            leftX() + rightward
            , topY() + downward
            , width()
            , height()
        );
    }

    @Override
    public Rectangle union (Rectangle that_)
    {
        final Rectangle2D that = toAwt(that_);
        return new AwtRectangle(delegate.createUnion(that));
    }

    private static Rectangle2D toAwt (Rectangle r)
    {
        return new Rectangle2D.Double(r.leftX(), r.topY(), r.width(), r.height());
    }
}
