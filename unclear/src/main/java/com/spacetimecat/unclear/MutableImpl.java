package com.spacetimecat.unclear;

final class MutableImpl<T> implements Mutable<T>
{
    private T x;

    MutableImpl ()
    {
    }

    MutableImpl (T x)
    {
        this.x = x;
    }

    @Override
    public T get ()
    {
        return x;
    }

    @Override
    public void set (T x)
    {
        this.x = x;
    }

    @Override
    public String toString ()
    {
        return String.format("[%s %s]", super.toString(), x);
    }
}
