package com.spacetimecat.gui.event;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * <p>
 *     This handles keyboard shortcuts.
 * </p>
 * <p>
 *     An application usually has only few instances of this,
 *     if not only one.
 * </p>
 */
@FunctionalInterface
public interface KeyboardHandler extends Consumer<KeyPress>
{
    static KeyboardHandler fromCollection (Collection<? extends KeyAction> mappings)
    {
        return new KeyboardHandlerImpl(mappings);
    }

    static KeyboardHandler fromArray (KeyAction... mappings)
    {
        return fromCollection(Arrays.asList(mappings));
    }
}
