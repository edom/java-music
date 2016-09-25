package com.spacetimecat.draw;

/**
 * <p>
 *     Stateful mutable graphics context such as color, font, transform.
 * </p>
 */
public interface Context
{
    void setFont (String name);

    void setFontSizePoint (double point);

    void translate (double rightward, double downward);
}
