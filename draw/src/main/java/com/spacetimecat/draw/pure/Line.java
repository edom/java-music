package com.spacetimecat.draw.pure;

final class Line implements Drawing
{
    private final double leftX;
    private final double topY;
    private final double rightX;
    private final double bottomY;

    Line (double leftX, double topY, double rightX, double bottomY)
    {
        this.leftX = leftX;
        this.topY = topY;
        this.rightX = rightX;
        this.bottomY = bottomY;
    }

    @Override
    public Drawing translated (double rightX, double downY)
    {
        return null;
    }
}
