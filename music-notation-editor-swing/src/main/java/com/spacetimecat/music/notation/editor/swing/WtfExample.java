package com.spacetimecat.music.notation.editor.swing;

import org.audiveris.proxymusic.Note;
import org.audiveris.proxymusic.Pitch;
import org.audiveris.proxymusic.ScorePartwise;
import org.audiveris.proxymusic.Step;
import org.audiveris.proxymusic.mxl.Mxl;
import org.audiveris.proxymusic.mxl.RootFile;
import org.audiveris.proxymusic.util.Marshalling;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class WtfExample
{
    private WtfExample () {}

    private static int diatone (Step step)
    {
        switch (step)
        {
            case C: return 0;
            case D: return 1;
            case E: return 2;
            case F: return 3;
            case G: return 4;
            case A: return 5;
            case B: return 6;
        }
        throw new UnsupportedOperationException(step.name());
    }

    private static int toHalfSpaceOffset (Pitch pitch)
    {
        final int diatone = diatone(pitch.getStep());
        final int octave = pitch.getOctave();
        final int diatonePerOctave = 7;
        final int diatonicPitchOrigin = diatonePerOctave * 5 + diatone(Step.F); // offset 0 is F5 in G clef
        return diatonicPitchOrigin - (diatonePerOctave * octave + diatone);
    }

    public static void main (String[] args) throws JAXBException, IOException, Mxl.MxlException, Marshalling.UnmarshallingException
    {
        // FIXME no way to close Mxl.Input
        final Mxl.Input input = new Mxl.Input(new File("/home/erik/test.mxl"));
        final List<RootFile> rootFiles = input.getRootFiles();
        assert rootFiles.size() == 1;
        final RootFile rootFile = rootFiles.get(0);
        final ScorePartwise score;
        try (final InputStream stream = input.getInputStream(input.getEntry(rootFile.fullPath)))
        {
            // ClassCastException, NullPointerException
            score = (ScorePartwise) Marshalling.unmarshal(stream);
        }
        assert score != null;
        final double px_per_sp = 12; // FIXME
        score.getPart().stream().flatMap(part ->
            part.getMeasure().stream().flatMap(measure ->
                measure.getNoteOrBackupOrForward().stream()
                .filter(x -> x instanceof Note)
                .map(x -> (Note) x)
                .map(Note::getPitch)
                .filter(Objects::nonNull)
                .map(WtfExample::toHalfSpaceOffset)
            )
        )
        .collect(Collectors.toList());
    }
}
