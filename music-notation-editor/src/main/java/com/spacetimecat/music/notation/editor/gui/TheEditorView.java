package com.spacetimecat.music.notation.editor.gui;

import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.music.notation.view.StaffView;
import com.spacetimecat.music.notation.view.StaffViewImpl;
import org.audiveris.proxymusic.Note;
import org.audiveris.proxymusic.Pitch;
import org.audiveris.proxymusic.ScorePartwise;
import org.audiveris.proxymusic.Step;
import org.audiveris.proxymusic.util.Marshalling;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class TheEditorView implements EditorView
{
    private final List<StaffView> staves = new ArrayList<>(64);
    private final Ruler ruler;
    private final Runnable repaint;
    private final Runnable quit;

    public TheEditorView (Ruler ruler, Runnable repaint, Runnable quit)
    {
        this.ruler = ruler;
        this.repaint = repaint;
        this.quit = quit;
        addStaff();
        getStaff(0).setSelected(true);
    }

    @Override
    public void addStaff ()
    {
        staves.add(new StaffViewImpl(5));
    }

    @Override
    public void export ()
    {
        final ScorePartwise score = new ScorePartwise();
        final List<ScorePartwise.Part> parts = staves.stream().map(staff ->
        {
            final ScorePartwise.Part part = new ScorePartwise.Part();
            ScorePartwise.Part.Measure measure = new ScorePartwise.Part.Measure();
            Note note = new Note();
            Pitch pitch = new Pitch();
            pitch.setStep(Step.C);
            pitch.setOctave(4);
            note.setPitch(pitch);
            note.setDuration(BigDecimal.ONE);
            measure.getNoteOrBackupOrForward().add(note);
            part.getMeasure().add(measure);
            return part;
        }).collect(Collectors.toList());
        score.getPart().addAll(parts);

        System.out.println(score);
        try
        {
            Marshalling.marshal(score, System.out, true, 4);
        }
        catch (Marshalling.MarshallingException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void quit ()
    {
        quit.run();
    }

    @Override
    public void repaint ()
    {
        repaint.run();
    }

    @Override
    public StaffView getStaff (int index)
    {
        return staves.get(index);
    }

    @Override
    public void draw (Drawer g)
    {
        final double px_per_sp = 12;
        final double fontHeight_px = 5 * px_per_sp;
        final double fontSize_pt = ruler.pt_from_px(fontHeight_px);
        // 1 sp is the distance between two adjacent spaces
        // (which is also the distance between two adjacent lines) in a staff
        final double sp = px_per_sp;
        g.setFont("Bravura");
        g.setFontSizePoint(fontSize_pt);
        g.translate(0, 200);
        staves.forEach(staff ->
        {
            try (final Drawer h = g.copy())
            {
                staff.setSpacing(1 * sp);
                staff.draw(h);
                final double spaceAfterStaff_px = 64;
                g.translate(0, staff.getHeight() + spaceAfterStaff_px);
            }
        });
    }
}
