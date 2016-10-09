package com.spacetimecat.music.notation.editor.musicxml;

import com.spacetimecat.music.notation.model.MutableNoteModelImpl;
import org.audiveris.proxymusic.Pitch;
import org.audiveris.proxymusic.ScorePartwise;
import org.audiveris.proxymusic.Step;

import java.math.BigDecimal;

public final class ConvertToMusicxml
{
    ScorePartwise score (Score score)
    {
        final ScorePartwise mxl = new ScorePartwise();
        // FIXME
        return mxl;
    }

    org.audiveris.proxymusic.Note note (MutableNoteModelImpl note)
    {
        final org.audiveris.proxymusic.Note result = new org.audiveris.proxymusic.Note();
        result.setDuration(BigDecimal.ONE);
        Pitch pitch = new Pitch();
        pitch.setStep(fromDiatone(note.getDiatone()));
        pitch.setOctave(note.getOctave());
        pitch.setStep(Step.C);
        result.setPitch(pitch);
        return result;
    }

    static Step fromDiatone (int diatone)
    {
        switch (diatone)
        {
            case 0: return Step.C;
            case 1: return Step.D;
            case 2: return Step.E;
            case 3: return Step.F;
            case 4: return Step.G;
            case 5: return Step.A;
            case 6: return Step.B;
        }
        throw new IllegalArgumentException();
    }
}
