package com.spacetimecat.gui.event;

final class KeyPressImpl implements KeyPress
{
    private final int modifiee;
    private final boolean ctrl;
    private final boolean alt;
    private final boolean shift;

    KeyPressImpl (int modifiee, boolean ctrl, boolean alt, boolean shift)
    {
        this.modifiee = modifiee;
        this.ctrl = ctrl;
        this.alt = alt;
        this.shift = shift;
    }

    @Override
    public int getModifiee ()
    {
        return modifiee;
    }

    @Override
    public boolean hasCtrl ()
    {
        return ctrl;
    }

    @Override
    public boolean hasAlt ()
    {
        return alt;
    }

    @Override
    public boolean hasShift ()
    {
        return shift;
    }

    /**
     * <p>
     *     Convert this into a string to be read by the user.
     * </p>
     *
     * @return something like {@code Ctrl-Alt-A}.
     */
    @Override
    public String toString ()
    {
        final StringBuilder builder = new StringBuilder(64);
        if (ctrl) { builder.append("Ctrl-"); }
        if (alt) { builder.append("Alt-"); }
        if (shift) { builder.append("Shift-"); }
        if (Character.isLetterOrDigit(modifiee))
        {
            builder.appendCodePoint(modifiee);
        }
        else
        {
            builder.append('<').append(modifiee).append('>');
        }
        return builder.toString();
    }

    @Override
    public boolean equals (Object that_)
    {
        if (!(that_ instanceof KeyPress)) { return false; }
        final KeyPress that = (KeyPress) that_;
        return
            modifiee == that.getModifiee()
            && this.hasCtrl() == that.hasCtrl()
            && this.hasAlt() == that.hasAlt()
            && this.hasShift() == that.hasShift()
        ;
    }

    @Override
    public int hashCode ()
    {
        int result = modifiee;
        result = 31 * result + (ctrl ? 1 : 0);
        result = 31 * result + (alt ? 1 : 0);
        result = 31 * result + (shift ? 1 : 0);
        return result;
    }
}
