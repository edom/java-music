package com.spacetimecat.music.notation.editor.gui;

/**
 * <p>
 *     Convert length units.
 * </p>
 */
public interface Ruler
{
    double pt_from_px (double x);

    double px_from_mm (double x);
}
