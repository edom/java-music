package com.spacetimecat.draw;

/**
 * <p>
 *     A {@link Drawable} base class.
 * </p>
 */
public abstract class AbstractDrawable implements Drawable
{
    protected AbstractDrawable () {}

    @Override
    public Drawable translated (double rightward, double downward)
    {
        return new TranslatedDrawable(this, rightward, downward);
    }

}
