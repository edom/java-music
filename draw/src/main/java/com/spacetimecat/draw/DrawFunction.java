package com.spacetimecat.draw;

@FunctionalInterface
public interface DrawFunction
{
    /**
     * <p>
     *     Translate this thing into drawing commands.
     * </p>
     */
    void draw (Drawer g);

    static DrawFunction empty ()
    {
        return (g) -> {};
    }
}
