package com.spacetimecat.music.notation.editor.swing;

import com.spacetimecat.unclear.OptionalKleisli;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class FindFirstPresent<A, B> implements OptionalKleisli<A, B>
{
    private final List<OptionalKleisli<A, B>> list = new ArrayList<>(8);

    @Override
    public Optional<B> apply (A a)
    {
        return list.stream()
            .map(k -> k.apply(a))
            .findFirst()
            .orElse(Optional.empty())
            ;
    }
}
