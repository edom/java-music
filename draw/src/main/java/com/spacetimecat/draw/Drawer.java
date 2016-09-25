package com.spacetimecat.draw;

/**
 * <p>
 *     Drawing commands similar to PostScript.
 * </p>
 */
public interface Drawer extends
    AutoCloseable
    , Context
    , Measure
    , Primitives
{
    @Override
    void close ();

    Drawer copy ();

    /**
     * Return a new {@link Drawer}
     */
    Drawer withFont (String name);

    /**
     * Return a new {@link Drawer}
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
     * @return a new {@link Drawer}
     */
    Drawer withTranslation (double rightward, double downward);
}
