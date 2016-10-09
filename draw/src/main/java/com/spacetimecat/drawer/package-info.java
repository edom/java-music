/**
 * <p>
 *     The interface {@link com.spacetimecat.drawer.Drawer}
 *     presents a low-level interface that feels like a PostScript interpreter
 *     in order to decouple the underlying graphics system.
 * </p>
 * <h3>Custom painting on AWT</h3>
 * <p>
 *     To obtain a {@link com.spacetimecat.drawer.Drawer},
 *     use {@link com.spacetimecat.drawer.awt.AwtDrawer#copyOf(java.awt.Graphics2D)}
 *     in your {@link java.awt.Component#paint(java.awt.Graphics)} implementation.
 * </p>
 */
package com.spacetimecat.drawer;
