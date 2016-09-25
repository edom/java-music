package com.spacetimecat.draw.pure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

final class DrawingList implements MutableDrawing
{
    private final Collection<Drawing> list = new ArrayList<>(64);

    static DrawingList of (Drawing... items)
    {
        final DrawingList list = new DrawingList();
        list.addAll(items);
        return list;
    }

    @Override
    public void addAll (Drawing... drawings)
    {
        list.addAll(Arrays.asList(drawings));
    }

    @Override
    public void line (double leftX, double topY, double rightX, double bottomY)
    {
        list.add(new Line(leftX, topY, rightX, bottomY));
    }
}
