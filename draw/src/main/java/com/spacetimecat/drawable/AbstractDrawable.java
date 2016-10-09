package com.spacetimecat.drawable;

/**
 * <p>
 *     A {@link Drawable} base class.
 * </p>
 */
abstract class AbstractDrawable implements Drawable
{
    @Override
    public final Drawable translated (double rightward, double downward)
    {
        return new TranslatedDrawable(this, rightward, downward);
    }
}
