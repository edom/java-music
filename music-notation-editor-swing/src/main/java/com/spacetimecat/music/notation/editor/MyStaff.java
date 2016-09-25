package com.spacetimecat.music.notation.editor;

import com.spacetimecat.draw.Drawer;
import com.spacetimecat.draw.AbstractDrawable;
import com.spacetimecat.draw.Rectangle;

final class MyStaff extends AbstractDrawable
{
    private double spacing = 20.0;
    private double width = 500.0;
    private int lineCount = 5;

    static MyStaff create ()
    {
        return new MyStaff();
    }

    public double getSpacing ()
    {
        return spacing;
    }

    public void setSpacing (double spacing)
    {
        this.spacing = spacing;
    }

    @Override
    public void draw (Drawer g)
    {
        for (int i = 0; i < lineCount; ++i)
        {
            final double y = spacing * i;
            g.line(0.0, y, 0.0 + width, y);
        }
    }

    @Override
    public Rectangle bounds (Drawer g)
    {
        // FIXME: ISP: MyStaff needs to implement something more specific
        throw new UnsupportedOperationException();
    }
}
