package com.spacetimecat.music.notation.view;

import com.spacetimecat.drawable.DrawFunction;
import com.spacetimecat.drawable.Drawable;
import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.music.notation.model.ClefModel;

import java.util.function.Supplier;

public class ClefDrawFunction implements DrawFunction
{
    private final ClefModel clef;
    private final Supplier<Double> spacing;

    public ClefDrawFunction (ClefModel clef, Supplier<Double> spacing)
    {
        this.clef = clef;
        this.spacing = spacing;
    }

    @Override
    public void draw (Drawer g)
    {
        // FIXME only for G clef; vertical offset (staff line number) should be in clefmodel
        Drawable.string(clef.getString()).translated(0, 3 * spacing.get()).draw(g);
    }
}
