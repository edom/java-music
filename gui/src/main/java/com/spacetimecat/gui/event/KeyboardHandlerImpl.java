package com.spacetimecat.gui.event;

import java.util.ArrayList;
import java.util.Collection;

final class KeyboardHandlerImpl implements KeyboardHandler
{
    private final Collection<? extends KeyAction> mappings;

    KeyboardHandlerImpl (Collection<? extends KeyAction> mappings)
    {
        this.mappings = new ArrayList<>(mappings);
    }

    @Override
    public void accept (KeyPress keyPress)
    {
        mappings.stream()
            .filter(action -> action.isTriggeredBy(keyPress))
            .findFirst()
            .ifPresent(KeyAction::perform)
        ;
    }
}
