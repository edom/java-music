package com.spacetimecat.music.notation.editor.swing;

import com.spacetimecat.music.notation.editor.gui.Ruler;

import java.awt.*;

/**
 * <p>
 *     Convert length units.
 * </p>
 * <p>
 *     If the display resolution changes while the application is running,
 *     the application may be affected by
 *     <a href="https://bugs.openjdk.java.net/browse/JDK-6516898">OpenJDK bug JDK-6516898</a>.
 * </p>
 * <p>
 *     Multimonitor systems are not supported.
 *     This class assumes that the system has exactly one monitor.
 * </p>
 */
public final class AwtRuler implements Ruler
{
    @SuppressWarnings("unused")
    private static final double px = 1;
    private final double in;
    private final double pt;
    private final double mm;

    private AwtRuler (Toolkit t)
    {
        in = t.getScreenResolution();
        pt = in / 72;
        mm = 25.4 * in;
    }

    public static AwtRuler create ()
    {
        return new AwtRuler(Toolkit.getDefaultToolkit());
    }

    @Override
    public double pt_from_px (double x)
    {
        return x / pt;
    }

    @Override
    public double px_from_mm (double x)
    {
        return x * mm;
    }
}
