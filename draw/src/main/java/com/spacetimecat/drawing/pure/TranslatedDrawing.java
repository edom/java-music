package com.spacetimecat.drawing.pure;

public class TranslatedDrawing implements Drawing
{
    private final Drawing original;
    private final double rightX;
    private final double downY;

    public TranslatedDrawing (Drawing original, double rightX, double downY)
    {
        this.original = original;
        this.rightX = rightX;
        this.downY = downY;
    }

    @Override
    public Drawing translated (double rightX, double downY)
    {
        return new TranslatedDrawing(original, this.rightX + rightX, this.downY + downY);
    }
}
