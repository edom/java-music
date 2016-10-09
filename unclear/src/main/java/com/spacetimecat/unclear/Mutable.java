package com.spacetimecat.unclear;

/**
 * <p>
 *     Mutable reference; typically used with reference aliasing.
 * </p>
 * @param <T> type of contained thing
 */
public interface Mutable<T>
{
    T get ();

    void set (T x);

    static <T> Mutable<T> of (T x)
    {
        return new MutableImpl<>(x);
    }
}
