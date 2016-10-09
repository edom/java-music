package com.spacetimecat.drawer;

/**
 * <p>
 *     This is similar to a PostScript interpreter.
 * </p>
 */
public interface Drawer extends
    AutoCloseable
    , Context
    , Measure
    , Primitives
{
    /**
     * <p>
     *     Release the resources used by this object.
     * </p>
     */
    @Override
    void close ();

    /**
     * <p>
     *     Create a copy of this drawer; the copy draws to the same surface
     *     but uses separate context (transformation, color, etc)
     *     that is initialized to the context of {@code this}
     *     when {@code this} is copied.
     * </p>
     *
     * @return a new instance
     */
    Drawer copy ();

    /**
     * Return a new instance.
     */
    Drawer withFont (String name);

    /**
     * Return a new instance.
     */
    Drawer withFontSize (double pixel);

    /**
     * <p>
     *     A copy with translation added
     *     (applied to the transformation matrix instead or replacing the matrix).
     * </p>
     * <p>
     *     {@code d.withTranslation(x0, y0).withTranslation(x1, y1) ~ d.withTranslation(x0 + x1, y0 + y1)}
     * </p>
     * @return a new instance
     */
    Drawer withTranslation (double rightward, double downward);
}
