package com.spacetimecat.music.notation.view;

import com.spacetimecat.drawable.DrawFunction;
import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.music.notation.model.ClefModel;
import com.spacetimecat.music.notation.model.MutableNoteModel;
import com.spacetimecat.music.notation.model.MutableStaffModel;

import java.util.ArrayList;
import java.util.List;

public final class StaffViewImpl implements StaffView
{
    private final List<DrawFunction> drawings = new ArrayList<>(64);

    private double width = 500.0;
    private double spacing = 10.0;
    private boolean selected;
    private int cursorPosition;

    private final MutableStaffModel model;

    public StaffViewImpl (int lineCount)
    {
        this.model = MutableStaffModel.create(lineCount);
    }

    @Override
    public int getLineCount ()
    {
        return model.getLineCount();
    }

    @Override
    public void backspace ()
    {
        final int n = drawings.size();
        if (n <= 0) { return; }
        drawings.remove(n - 1);
    }

    @Override
    public void addNote (MutableNoteModel note)
    {
        drawings.add(new NoteDrawFunction(note, this::getSpacing));
    }

    @Override
    public void addClef (ClefModel clef)
    {
        drawings.add(new ClefDrawFunction(clef, this::getSpacing));
    }

    @Override
    public double getHeight ()
    {
        // XXX line thickness not yet included?
        return (getLineCount() - 1) * spacing;
    }

    @Override
    public double getSpacing ()
    {
        return spacing;
    }

    @Override
    public void setSpacing (double spacing)
    {
        if (spacing < 0) { throw new IllegalArgumentException("spacing < 0"); }
        this.spacing = spacing;
    }

    @Override
    public double getWidth ()
    {
        return width;
    }

    @Override
    public void draw (Drawer g)
    {
        for (int i = 0; i < getLineCount(); ++i)
        {
            final double y = spacing * i;
            g.line(0.0, y, 0.0 + width, y);
        }
        drawings.forEach(child -> child.draw(g));
    }

    @Override
    public boolean isSelected ()
    {
        return selected;
    }

    @Override
    public void setSelected (boolean selected)
    {
        this.selected = selected;
    }

    @Override
    public int getCursorPosition ()
    {
        return cursorPosition;
    }

    @Override
    public void setCursorPosition (int position)
    {
        this.cursorPosition = position;
    }

    @Override
    public void transpose (int diatone, double accidental)
    {
        model.transpose(diatone, accidental);
    }
}
