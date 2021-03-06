package org.jfree.chart.swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;


/**
 * A strategy for zooming plots on the chart panel by selecting a smaller region on the initial screen.
 *
 * See {@link ChartPanel#setSelectionZoomStrategy(SelectionZoomStrategy)}
 */
public interface SelectionZoomStrategy extends Serializable {

    /**
     * If controller currently tracking zoom rectangle
     *
     * @return {@code true} if zoomRectangle exists for this controller
     *          and {@code false} otherwise
     */
    boolean isActivated();

    /**
     * The zoom rectangle starting point (selected by the user with a mouse
     * click).  This is a point on the screen, not the chart (which may have
     * been scaled up or down to fit the panel).
     */
    Point2D getZoomPoint();

    void setZoomPoint(Point2D zoomPoint);

    /**
     * Sets the zoom trigger distance.  This controls how far the mouse must
     * move before a zoom action is triggered.
     *
     * @param distance  the distance (in Java2D units).
     */
    void setZoomTriggerDistance(int distance);

    /**
     * Returns the zoom trigger distance.  This controls how far the mouse must
     * move before a zoom action is triggered.
     *
     * @return The distance (in Java2D units).
     */
    int getZoomTriggerDistance();

    /**
     * Returns the zoom rectangle outline paint.
     *
     * @return The zoom rectangle outline paint (never {@code null}).
     *
     * @see #setZoomOutlinePaint(java.awt.Paint)
     * @see #setFillZoomRectangle(boolean)
     *
     * @since 1.0.13
     */
    Paint getZoomOutlinePaint();

    /**
     * Sets the zoom rectangle outline paint.
     *
     * @param paint  the paint ({@code null} not permitted).
     *
     * @see #getZoomOutlinePaint()
     * @see #getFillZoomRectangle()
     *
     * @since 1.0.13
     */
    void setZoomOutlinePaint(Paint paint);

    /**
     * Returns the zoom rectangle fill paint.
     *
     * @return The zoom rectangle fill paint (never {@code null}).
     *
     * @see #setZoomFillPaint(Paint)
     * @see #setFillZoomRectangle(boolean)
     *
     * @since 1.0.13
     */
    Paint getZoomFillPaint();

    /**
     * Sets the zoom rectangle fill paint.
     *
     * @param paint  the paint ({@code null} not permitted).
     *
     * @see #getZoomFillPaint()
     * @see #getFillZoomRectangle()
     *
     * @since 1.0.13
     */
    void setZoomFillPaint(Paint paint);

    /**
     * Returns the flag that controls whether or not the zoom rectangle is
     * filled when drawn.
     *
     * @return A boolean.
     */
    boolean getFillZoomRectangle();

    /**
     * A flag that controls how the zoom rectangle is drawn.
     *
     * @param flag  {@code true} instructs to fill the rectangle on
     *              zoom, otherwise it will be outlined.
     */
    void setFillZoomRectangle(boolean flag);

    /**
     * Updates zoom rectangle with new mouse position

     * @param e mouse event
     * @param hZoom if horizontal zoom allowed
     * @param vZoom if vertical zoom allowed
     * @param scaledDataArea plot area in screen coordinates
     */
    void updateZoomRectangleSelection(MouseEvent e, boolean hZoom, boolean vZoom, Rectangle2D scaledDataArea);

    /**
     * Creates and returns current zoom rectangle
     *
     * @param hZoom if horizontal zoom acceptable
     * @param vZoom if vertical zoom acceptable
     * @param screenDataArea rectangle that describes plot on the screen
     *
     * @return rectangle in java2d screen coordinates selected by user
     */
    Rectangle2D getZoomRectangle(boolean hZoom, boolean vZoom, Rectangle2D screenDataArea);

    /**
     * Removes zoom rectangle
     */
    void reset();

    /**
     * Draws zoom rectangle (if present).
     * The drawing is performed in XOR mode, therefore
     * when this method is called twice in a row,
     * the second call will completely restore the state
     * of the canvas.
     *
     *  @param g2 the graphics device.
     * @param xor  use XOR for drawing?
     */
    void drawZoomRectangle(Graphics2D g2, boolean xor);
}
