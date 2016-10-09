package com.spacetimecat.gui.event;

/**
 * <p>
 *     Description of a keyboard shortcut.
 * </p>
 * <p>
 *     An instance of {@link KeyboardShortcut} means that if
 *     the user presses the {@link #getKeyPress()} combination,
 *     then the action described in {@link #getTitle()} is performed.
 * </p>
 */
public interface KeyboardShortcut
{
    /**
     * <p>
     *     The combination of keys that is supposed to trigger this action.
     * </p>
     *
     * @return see description
     */
    KeyPress getKeyPress ();

    /**
     * <p>
     *     Example: "Close window".
     * </p>
     *
     * @return a title
     */
    String getTitle ();

    default boolean isTriggeredBy (KeyPress k)
    {
        return getKeyPress().equals(k);
    }

    /**
     * <p>
     *     A string if the title is not clear enough;
     *     usually this is the empty string.
     * </p>
     *
     * @return a description, or the empty string if there is no description
     */
    default String getDescription ()
    {
        return "";
    }
}
