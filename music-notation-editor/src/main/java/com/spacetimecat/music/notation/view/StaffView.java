package com.spacetimecat.music.notation.view;

import com.spacetimecat.drawable.DrawFunction;
import com.spacetimecat.music.notation.model.MutableStaffModel;

public interface StaffView extends MutableStaffModel, DrawFunction, HasCursor, Selectable, StaffActions
{
    double getHeight ();

    double getSpacing ();

    void setSpacing (double spacing);

    double getWidth ();
}
