package com.spacetimecat.geometry;

final class RectangleImpl implements Rectangle
{
    private final double leftX;
    private final double topY;
    private final double rightX;
    private final double bottomY;

    RectangleImpl (double leftX, double topY, double rightX, double bottomY)
    {
        if (leftX > rightX) { throw new IllegalArgumentException("leftX > rightX"); }
        if (topY > bottomY) { throw new IllegalArgumentException("topY > bottomY"); }
        this.leftX = leftX;
        this.topY = topY;
        this.rightX = rightX;
        this.bottomY = bottomY;
    }

    @Override
    public double leftX ()
    {
        return leftX;
    }

    @Override
    public double topY ()
    {
        return topY;
    }

    @Override
    public double rightX ()
    {
        return rightX;
    }

    @Override
    public double bottomY ()
    {
        return bottomY;
    }

    @Override
    public double width ()
    {
        return rightX - leftX;
    }

    @Override
    public double height ()
    {
        return bottomY - topY;
    }

    @Override
    public Rectangle translated (double rightward, double downward)
    {
        return new RectangleImpl(leftX + rightward, topY + downward, rightX + rightward, bottomY + downward);
    }

    @Override
    public Rectangle union (Rectangle that)
    {
        return new RectangleImpl(
            Math.min(leftX, that.leftX())
            , Math.min(topY, that.topY())
            , Math.max(rightX, that.rightX())
            , Math.max(bottomY, that.bottomY())
        );
    }
}
