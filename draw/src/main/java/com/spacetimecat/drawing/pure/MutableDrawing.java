package com.spacetimecat.drawing.pure;

public interface MutableDrawing // TODO rename to Canvas
{
    void addAll (Drawing... drawings);

    void line (double leftX, double topY, double rightX, double bottomY);
}
