package com.spacetimecat.music.notation.editor;

import com.spacetimecat.draw.*;

import javax.swing.*;
import java.awt.*;

final class MyCanvas extends JComponent
{
    MyCanvas ()
    {
        setPreferredSize(new Dimension(640, 480));
        setMinimumSize(new Dimension(640, 480));
        setDoubleBuffered(true);
    }

    @Override
    public void paint (Graphics g_)
    {
        super.paint(g_);
        final Graphics2D g = (Graphics2D) g_;
        g.setFont(Font.decode("Bravura-64"));
        // FIXME what if the screen changes? e.g. user plugs in a monitor
        final double px_per_in = Toolkit.getDefaultToolkit().getScreenResolution();
        final double pt_per_in = 72.0;
        final double px_per_pt = px_per_in / pt_per_in;
        final double px_per_sp = 12;
        final double fontHeight_px = 5 * px_per_sp;
        final double fontSize_pt = fontHeight_px / px_per_pt;
        final double sp = px_per_sp;
        // 1 sp is the distance between two adjacent spaces
        // (which is also the distance between two adjacent lines) in a staff
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        try (final Drawer cmds = AwtDrawer.copyOf(g))
        {
            cmds.setFont("Bravura");
            cmds.setFontSizePoint(fontSize_pt);
            cmds.translate(0, 200);
            {
                final MyStaff staff = MyStaff.create();
                final Drawable note = Note.quarter();
                final Drawable note2 = Note.quarter().translated(0, 1 * sp);
                final Drawable cg = Clef.g().translated(0, 3 * sp);
                final Drawable cf = Clef.f().translated(0, 1 * sp);
                final Drawable s = Drawable.horizontalSpace(2 * sp);
                staff.setSpacing(1 * sp);
                staff.draw(cmds);
                Drawable.rightwards(cg, s, cf, s, note, s, note2, s).draw(cmds);
            }
            cmds.setFont("SansSerif");
            cmds.setFontSizePoint(12);
            Drawable.downwards
            (
                Drawable.string("foo")
                , Drawable.string("bar")
                , Drawable.string("baz")
            ).translated(0, 200).draw(cmds);
        }
    }
}
