package com.spacetimecat.music.notation.model;

public interface MutableStaffModel extends StaffModel, MutableTransposable
{
    /**
     * <p>
     *     Put the note after the last note in the staff.
     * </p>
     * @param note
     */
    void addNote (MutableNoteModel note);

    void addClef (ClefModel clef);

    static MutableStaffModel create (int lineCount)
    {
        return new MutableStaffModelImpl(lineCount);
    }
}
