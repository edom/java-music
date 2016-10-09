package com.spacetimecat.music.notation.editor.musicxml;

import com.spacetimecat.music.notation.model.StaffModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Score
{
    private final List<StaffModel> staves = new ArrayList<>(64);

    public List<StaffModel> staves ()
    {
        return Collections.unmodifiableList(staves);
    }
}
