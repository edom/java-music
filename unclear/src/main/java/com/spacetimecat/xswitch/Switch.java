package com.spacetimecat.xswitch;

import java.util.Arrays;
import java.util.function.Predicate;

@FunctionalInterface
public interface Switch<T>
{
    boolean checkAndRun (T value);

    static <T> Switch<T> of (Predicate<T> predicate, Runnable action)
    {
        return value ->
        {
            final boolean matches = predicate.test(value);
            if (matches) { action.run(); }
            return matches;
        };
    }

    static <T> Switch<T> firstIn (Iterable<? extends Switch<T>> list)
    {
        return event ->
        {
            for (final Switch<T> item : list)
            {
                if (item.checkAndRun(event))
                {
                    return true;
                }
            }
            return false;
        };
    }

    static <T> Switch<T> firstIn (Switch<T>... list)
    {
        return firstIn(Arrays.asList(list));
    }
}
