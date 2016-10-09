package com.spacetimecat.drawer.awt;

import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.geometry.Rectangle;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * <p>
 *     A {@link Drawer} that uses AWT that comes with Java Standard Edition.
 * </p>
 */
public final class AwtDrawer implements Drawer
{
    private final Graphics2D g;

    private AwtDrawer (Graphics2D g)
    {
        this.g = g;
    }

    public static Drawer copyOf (Graphics2D g)
    {
        return new AwtDrawer((Graphics2D) g.create());
    }

    @Override
    public void close ()
    {
        g.dispose();
    }

    @Override
    public Drawer copy ()
    {
        return copyOf(g);
    }

    @Override
    public void setFont (String name)
    {
        g.setFont(Font.decode(name));
    }

    @Override
    public void setFontSizePoint (double point)
    {
        g.setFont(g.getFont().deriveFont((float) point));
    }

    @Override
    public void translate (double rightward, double downward)
    {
        g.translate(rightward, downward);
    }

    @Override
    public Drawer withFont (String name)
    {
        final Graphics2D h = (Graphics2D) g.create();
        h.setFont(Font.decode(name));
        return new AwtDrawer(h);
    }

    @Override
    public Drawer withFontSize (double pixel)
    {
        final Graphics2D h = (Graphics2D) g.create();
        h.setFont(g.getFont().deriveFont((float) pixel));
        return new AwtDrawer(h);
    }

    @Override
    public void line (double leftX, double topY, double rightX, double bottomY)
    {
        g.draw(new Line2D.Double(leftX, topY, rightX, bottomY));
    }

    @Override
    public void string (String string, double leftX, double baselineY)
    {
        g.drawString(string, (float) leftX, (float) baselineY);
    }

    @Override
    public Rectangle boundsOf (String string)
    {
        final Font font = g.getFont();
        final FontRenderContext context = g.getFontRenderContext();
        final Rectangle2D r = font.getStringBounds(string, context);
        return AwtRectangle.from(r);
    }

    @Override
    public Drawer withTranslation (double rightward, double downward)
    {
        final Graphics2D h = (Graphics2D) g.create();
        h.translate(rightward, downward);
        return new AwtDrawer(h);
    }
}
