/**
 * <p>
 *     This decouples the entire library from the drawing implementation.
 * </p>
 * <p>
 *     See the interfaces {@link com.spacetimecat.draw.Drawer} and {@link com.spacetimecat.draw.Drawable}.
 * </p>
 * <h3>Custom painting on AWT</h3>
 * <p>
 *     To obtain a {@link com.spacetimecat.draw.Drawer},
 *     use {@link com.spacetimecat.draw.AwtDrawer#copyOf(java.awt.Graphics2D)}
 *     in your {@link java.awt.Component#paint(java.awt.Graphics)} implementation.
 * </p>
 */
package com.spacetimecat.draw;
