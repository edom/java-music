package com.spacetimecat.drawer;

/**
 * <p>
 *     This receives messages that are named after drawing primitives.
 * </p>
 */
public interface Primitives
{
    /**
     * Add a straight line.
     */
    void line (double leftX, double topY, double rightX, double bottomY);

    /**
     * Add a string (anything coming from a font).
     */
    void string (String string, double leftX, double baselineY);
}
