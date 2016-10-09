package com.spacetimecat.unclear;

import java.util.Optional;
import java.util.function.Function;

// TODO generalize ViewOf to OptionalKleisli<Object, Drawable>
// Kleisli arrow
@FunctionalInterface
public interface OptionalKleisli<A, B> extends Function<A, Optional<B>>
{
}
