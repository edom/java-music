package com.spacetimecat.draw;

final class TranslatedDrawable implements Drawable
{
    private final Drawable inner;
    private final double rightward;
    private final double downward;

    TranslatedDrawable (Drawable inner, double rightward, double downward)
    {
        this.inner = inner;
        this.rightward = rightward;
        this.downward = downward;
    }


    @Override
    public Rectangle bounds (Drawer g)
    {
        return inner.bounds(g).translated(rightward, downward);
    }

    @Override
    public void draw (Drawer g)
    {
        try (final Drawer h = g.withTranslation(rightward, downward))
        {
            inner.draw(h);
        }
    }

    @Override
    public Drawable translated (double rightward, double downward)
    {
        return new TranslatedDrawable(inner, this.rightward + rightward, this.downward + downward);
    }
}
