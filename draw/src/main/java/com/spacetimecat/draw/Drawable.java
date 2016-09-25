package com.spacetimecat.draw;

/**
 * <p>
 *     A thing that knows how to draw itself using a {@link Drawer}.
 * </p>
 */
public interface Drawable extends Bounded, DrawFunction
{
    Drawable translated (double rightward, double downward);

    static Drawable empty ()
    {
        return new EmptyDrawable();
    }

    static Drawable rightwards (Drawable... items)
    {
        return Rightwards.of(items);
    }

    static Drawable downwards (Drawable... items)
    {
        return Downwards.of(items);
    }

    static Drawable horizontalSpace (double width)
    {
        return Spacer.fromSize(width, 0);
    }

    static Drawable string (String string)
    {
        return new StringDrawable(string);
    }
}
