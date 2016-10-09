package com.spacetimecat.predicate;

import java.util.List;
import java.util.function.Predicate;

/**
 * <p>
 *     The predicate {@code new Any(list)} is satisfied iff
 *     there exists a satisfied predicate in the list.
 * </p>
 * @param <T> the domain of the predicate
 */
public final class Any<T> implements Predicate<T>
{
    private final List<Predicate<T>> predicates;

    private Any (List<Predicate<T>> predicates)
    {
        this.predicates = predicates;
    }

    /**
     * <p>
     *     This returns a predicate that is satisfied iff
     *     there exists a satisfied predicate in the list.
     * </p>
     */
    public static <T> Predicate<T> of (List<Predicate<T>> predicates)
    {
        return new Any<>(predicates);
    }

    @Override
    public boolean test (T t)
    {
        for (final Predicate<T> predicate : predicates)
        {
            if (predicate.test(t))
            {
                return true;
            }
        }
        return false;
    }
}
