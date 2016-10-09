package com.spacetimecat.gui.event;

/**
 * <p>
 *     A key (called a <em>modifiee</em>) and maybe some modifiers such as Ctrl, Alt, or Shift.
 * </p>
 */
public interface KeyPress
{
    int getModifiee ();

    /**
     * <p>
     *     True iff Ctrl was down while the modifiee was pressed.
     * </p>
     *
     * @return see description
     */
    boolean hasCtrl ();

    /**
     * <p>
     *     True iff Alt was down while the modifiee was pressed.
     * </p>
     *
     * @return see description
     */
    boolean hasAlt ();

    /**
     * <p>
     *     True iff Shift was down while the modifiee was pressed.
     * </p>
     *
     * @return see description
     */
    boolean hasShift ();

    /**
     * <p>
     * True iff the modifiees and modifiers are equal.
     * </p>
     *
     * @param that the other object
     *
     * @return see description
     */
    @Override
    boolean equals (Object that);

    @Override
    int hashCode ();

    default KeyAction createAction (String title, Runnable action)
    {
        return KeyAction.create(this, title, action);
    }

    static KeyPress create (int modifiee, boolean ctrl, boolean alt, boolean shift)
    {
        return new KeyPressImpl(modifiee, ctrl, alt, shift);
    }

    /**
     * <p>
     *     Just the key and no modifiers.
     * </p>
     *
     * @param modifiee
     * if you use character literal from the set of ASCII character letters,
     * make sure it is uppercase
     *
     * @return a new instance
     */
    static KeyPress just (int modifiee)
    {
        return new KeyPressImpl(modifiee, false, false, false);
    }

    /**
     * <p>
     *     Ctrl and a key.
     * </p>
     *
     * @param modifiee see {@link #just(int)}
     *
     * @return a new instance
     */
    static KeyPress ctrl (int modifiee)
    {
        return new KeyPressImpl(modifiee, true, false, false);
    }
}
