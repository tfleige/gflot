/*
 * Copyright (c) 2012 Nicolas Morel
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package com.googlecode.gflot.client.options;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.googlecode.gflot.client.jsni.JsonObject;

/**
 * The grid is the thing with the axes and a number of ticks.
 *
 * @author Alexander De Leon
 */
public class GridOptions
    extends JsonObject
{
    public static class Margin extends JsonObject
    {

        private static final String MARGIN_TOP_KEY = "top";
        private static final String MARGIN_RIGHT_KEY = "right";
        private static final String MARGIN_BOTTOM_KEY = "bottom";
        private static final String MARGIN_LEFT_KEY = "left";

        /**
         * Creates a {@link Margin}
         */
        public static final Margin create()
        {
            return JavaScriptObject.createObject().cast();
        }

        /**
         * Creates a {@link Margin}
         */
        public static final Margin of( double top, double right, double bottom, double left )
        {
            Margin margin = Margin.create();
            margin.setTop( top );
            margin.setRight( right );
            margin.setBottom( bottom );
            margin.setLeft( left );
            return margin;
        }

        protected Margin()
        {
        }

        /**
         * Set the top margin
         */
        public final Margin setTop( double top )
        {
            put( MARGIN_TOP_KEY, top );
            return this;
        }

        /**
         * @return the top margin
         */
        public final Double getTop()
        {
            return getDouble( MARGIN_TOP_KEY );
        }

        /**
         * Clear the top margin
         */
        public final Margin clearTop()
        {
            clear( MARGIN_TOP_KEY );
            return this;
        }

        /**
         * Set the right margin
         */
        public final Margin setRight( double right )
        {
            put( MARGIN_RIGHT_KEY, right );
            return this;
        }

        /**
         * @return the right margin
         */
        public final Double getRight()
        {
            return getDouble( MARGIN_RIGHT_KEY );
        }

        /**
         * Clear the right margin
         */
        public final Margin clearRight()
        {
            clear( MARGIN_RIGHT_KEY );
            return this;
        }

        /**
         * Set the bottom margin
         */
        public final Margin setBottom( double bottom )
        {
            put( MARGIN_BOTTOM_KEY, bottom );
            return this;
        }

        /**
         * @return the bottom margin
         */
        public final Double getBottom()
        {
            return getDouble( MARGIN_BOTTOM_KEY );
        }

        /**
         * Clear the bottom margin
         */
        public final Margin clearBottom()
        {
            clear( MARGIN_BOTTOM_KEY );
            return this;
        }

        /**
         * Set the left margin
         */
        public final Margin setLeft( double left )
        {
            put( MARGIN_LEFT_KEY, left );
            return this;
        }

        /**
         * @return the left margin
         */
        public final Double getLeft()
        {
            return getDouble( MARGIN_LEFT_KEY );
        }

        /**
         * Clear the left margin
         */
        public final Margin clearLeft()
        {
            clear( MARGIN_LEFT_KEY );
            return this;
        }

    }

    private static final String COLOR_KEY = "color";
    private static final String BACKGROUND_COLOR_KEY = "backgroundColor";
    private static final String BACKGROUND_COLORS_KEY = "colors";
    private static final String SHOW_KEY = "show";
    private static final String ABOVE_DATA_KEY = "aboveData";
    private static final String LABEL_MARGIN_KEY = "labelMargin";
    private static final String AXIS_MARGIN_KEY = "axisMargin";
    private static final String MARKINGS_KEY = "markings";
    private static final String MARKINGS_COLOR_KEY = "markingsColor";
    private static final String MARKINGS_LINE_WIDTH_KEY = "markingsLineWidth";
    private static final String BORDER_WIDTH_KEY = "borderWidth";
    private static final String BORDER_COLOR_KEY = "borderColor";
    private static final String MIN_BORDER_MARGIN_KEY = "minBorderMargin";
    private static final String CLICKABLE_KEY = "clickable";
    private static final String HOVERABLE_KEY = "hoverable";
    private static final String AUTO_HIGHLIGHT_KEY = "autoHighlight";
    private static final String MOUSE_ACTIVE_RADIUS_KEY = "mouseActiveRadius";
    private static final String MARGIN_KEY = "margin";

    /**
     * Creates a {@link GridOptions}
     */
    public static final GridOptions create()
    {
        return JavaScriptObject.createObject().cast();
    }

    protected GridOptions()
    {
    }

    /**
     * Set the color of the grid itself
     */
    public final GridOptions setColor( String color )
    {
        put( COLOR_KEY, color );
        return this;
    }

    /**
     * @return the color of the grid itself
     */
    public final String getColor()
    {
        return getString( COLOR_KEY );
    }

    /**
     * Clear the color of the grid
     */
    public final GridOptions clearColor()
    {
        clear( COLOR_KEY );
        return this;
    }

    /**
     * Set the background color inside the grid area. null (default) means that the background is transparent.
     */
    public final GridOptions setBackgroundColor( String color )
    {
        put( BACKGROUND_COLOR_KEY, color );
        return this;
    }

    /**
     * Set the background color inside the grid area as a gradient.
     */
    public final GridOptions setBackgroundColor( String fromColor, String toColor )
    {
        JsArrayString array = getBackgroundColorAsArray();
        if ( null == array )
        {
            JsonObject jsonObject = JavaScriptObject.createObject().cast();
            array = JavaScriptObject.createArray().cast();
            jsonObject.put( BACKGROUND_COLORS_KEY, array );
            put( BACKGROUND_COLOR_KEY, jsonObject );
        }
        array.set( 0, fromColor );
        array.set( 1, toColor );
        return this;
    }

    /**
     * @return the background color inside the grid area. The result can be a {@link String} or a
     *         {@link JavaScriptObject}.
     */
    public final Object getBackgroundColor()
    {
        return getObject( BACKGROUND_COLOR_KEY );
    }

    /**
     * @return the background color inside the grid area. The result can be a {@link String} or a
     *         {@link JavaScriptObject}.
     */
    public final String getBackgroundColorAsString()
    {
        Object color = getObject( BACKGROUND_COLOR_KEY );
        return (String) (color instanceof String ? color : null);
    }

    /**
     * @return the background color inside the grid area. The result can be a {@link String} or a
     *         {@link JavaScriptObject}.
     */
    public final JsArrayString getBackgroundColorAsArray()
    {
        Object color = getObject( BACKGROUND_COLOR_KEY );
        return (color instanceof JavaScriptObject ? ((JsonObject) color).getStringArray( BACKGROUND_COLORS_KEY )
            : null);
    }

    /**
     * Clear the background color inside the grid area
     */
    public final GridOptions clearBackgroundColor()
    {
        clear( BACKGROUND_COLOR_KEY );
        return this;
    }

    /**
     * Set if the whole grid including tick labels should be shown.
     */
    public final GridOptions setShow( boolean show )
    {
        put( SHOW_KEY, show );
        return this;
    }

    /**
     * @return true if the grid is visible
     */
    public final Boolean getShow()
    {
        return getBoolean( SHOW_KEY );
    }

    /**
     * Clear if the grid is visible or not
     */
    public final GridOptions clearShow()
    {
        clear( SHOW_KEY );
        return this;
    }

    /**
     * Set whether the grid is drawn above the data or below (below is default).
     */
    public final GridOptions setAboveData( boolean aboveData )
    {
        put( ABOVE_DATA_KEY, aboveData );
        return this;
    }

    /**
     * @return whether the grid is drawn above the data or below
     */
    public final Boolean getAboveData()
    {
        return getBoolean( ABOVE_DATA_KEY );
    }

    /**
     * Clear the above data option
     */
    public final GridOptions clearAboveData()
    {
        clear( ABOVE_DATA_KEY );
        return this;
    }

    /**
     * Set the space in pixels between tick labels and axis line
     */
    public final GridOptions setLabelMargin( int labelMargin )
    {
        put( LABEL_MARGIN_KEY, labelMargin );
        return this;
    }

    /**
     * @return the space in pixels between tick labels and axis line
     */
    public final Integer getLabelMargin()
    {
        return getInteger( LABEL_MARGIN_KEY );
    }

    /**
     * Clear the space in pixels between tick labels and axis line
     */
    public final GridOptions clearLabelMargin()
    {
        clear( LABEL_MARGIN_KEY );
        return this;
    }

    /**
     * Set the space in pixels between axes when there are two next to each other
     */
    public final GridOptions setAxisMargin( int axisMargin )
    {
        put( AXIS_MARGIN_KEY, axisMargin );
        return this;
    }

    /**
     * @return the space in pixels between axes when there are two next to each other
     */
    public final Integer getAxisMargin()
    {
        return getInteger( AXIS_MARGIN_KEY );
    }

    /**
     * Clear the space in pixels between axes when there are two next to each other
     */
    public final GridOptions clearAxisMargin()
    {
        clear( AXIS_MARGIN_KEY );
        return this;
    }

    /**
     * Sets markings to the grid. It is used to draw simple lines and rectangular areas in the background of the plot.
     */
    public final GridOptions setMarkings( Markings markings )
    {
        put( MARKINGS_KEY, markings );
        return this;
    }

    /**
     * @return the markings
     */
    public final Markings getMarkings()
    {
        return getJsObject( MARKINGS_KEY );
    }

    /**
     * Sets the colors of all markings. Specific color can be defined in Marking object
     */
    public final GridOptions setMarkingsColor( String color )
    {
        put( MARKINGS_COLOR_KEY, color );
        return this;
    }

    /**
     * @return the markings color
     */
    public final String getMarkingsColor()
    {
        return getString( MARKINGS_COLOR_KEY );
    }

    /**
     * Clear the markings color
     */
    public final GridOptions clearMarkingsColor()
    {
        clear( MARKINGS_COLOR_KEY );
        return this;
    }

    /**
     * Sets the line width of all markings. Specific line width can be defined in Marking object
     */
    public final GridOptions setMarkingsLineWidth( int lineWidth )
    {
        put( MARKINGS_LINE_WIDTH_KEY, lineWidth );
        return this;
    }

    /**
     * @return the markings line width
     */
    public final Integer getMarkingsLineWidth()
    {
        return getInteger( MARKINGS_LINE_WIDTH_KEY );
    }

    /**
     * Clear the markings line width
     */
    public final GridOptions clearMarkingsLineWidth()
    {
        clear( MARKINGS_LINE_WIDTH_KEY );
        return this;
    }

    /**
     * Set the width of the border around the plot. Set it to 0 to disable the border.
     */
    public final GridOptions setBorderWidth( int borderWidth )
    {
        assert borderWidth >= 0 : "borderWith must be positive";

        put( BORDER_WIDTH_KEY, borderWidth );
        return this;
    }

    /**
     * @return the width of the border around the plot
     */
    public final Integer getBorderWidth()
    {
        return getInteger( BORDER_WIDTH_KEY );
    }

    /**
     * Clear the border's width
     */
    public final GridOptions clearBorderWidth()
    {
        clear( BORDER_WIDTH_KEY );
        return this;
    }

    /**
     * Set the color of the border. By default, it's the same color than the grid lines.
     */
    public final GridOptions setBorderColor( String borderColor )
    {
        put( BORDER_COLOR_KEY, borderColor );
        return this;
    }

    /**
     * @return the color of the border
     */
    public final String getBorderColor()
    {
        return getString( BORDER_COLOR_KEY );
    }

    /**
     * Clear the color of the border
     */
    public final GridOptions clearBorderColor()
    {
        clear( BORDER_COLOR_KEY );
        return this;
    }

    /**
     * "minBorderMargin" controls the default minimum margin around the border - it's used to make sure that points
     * aren't accidentally clipped by the canvas edge so by default the value is computed from the point radius
     */
    public final GridOptions setMinBorderMargin( int minBorderMargin )
    {
        assert minBorderMargin >= 0 : "minBorderMargin must be positive";

        put( MIN_BORDER_MARGIN_KEY, minBorderMargin );
        return this;
    }

    /**
     * @return the default minimum margin around the border
     */
    public final Integer getMinBorderMargin()
    {
        return getInteger( MIN_BORDER_MARGIN_KEY );
    }

    /**
     * Clear the default minimum margin around the border
     */
    public final GridOptions clearMinBorderMargin()
    {
        clear( MIN_BORDER_MARGIN_KEY );
        return this;
    }

    /**
     * Set if the plot will listen for click events on the plot area. Add a PlotClickListener to the plot to listen to
     * the event.
     */
    public final GridOptions setClickable( boolean clickable )
    {
        put( CLICKABLE_KEY, clickable );
        return this;
    }

    /**
     * @return true if the grid is clickable
     */
    public final Boolean getClickable()
    {
        return getBoolean( CLICKABLE_KEY );
    }

    /**
     * Clear the clickable option
     */
    public final GridOptions clearClickable()
    {
        clear( CLICKABLE_KEY );
        return this;
    }

    /**
     * Set if the plot will listen for mouse move events on the plot area. Add a PlotHoverListener to the plot to listen
     * to the event.
     */
    public final GridOptions setHoverable( boolean hoverable )
    {
        put( HOVERABLE_KEY, hoverable );
        return this;
    }

    /**
     * @return true if the grid is hoverable
     */
    public final Boolean getHoverable()
    {
        return getBoolean( HOVERABLE_KEY );
    }

    /**
     * Clear the hoverable option
     */
    public final GridOptions clearHoverable()
    {
        clear( HOVERABLE_KEY );
        return this;
    }

    /**
     * Set if nearby data items are highlighted automatically (default is true)
     */
    public final GridOptions setAutoHighlight( boolean autoHighlight )
    {
        put( AUTO_HIGHLIGHT_KEY, autoHighlight );
        return this;
    }

    /**
     * @return true if nearby data items are highlighted automatically (default is true)
     */
    public final Boolean getAutoHighlight()
    {
        return getBoolean( AUTO_HIGHLIGHT_KEY );
    }

    /**
     * Clear the auto highlight option
     */
    public final GridOptions clearAutoHighlight()
    {
        clear( AUTO_HIGHLIGHT_KEY );
        return this;
    }

    /**
     * Set how far the mouse can be from an item and still activate it. If there are two or more points within this
     * radius, Flot chooses the closest item. For bars, the top-most bar (from the latest specified data series) is
     * chosen.
     */
    public final GridOptions setMouseActiveRadius( int mouseActiveRadius )
    {
        put( MOUSE_ACTIVE_RADIUS_KEY, mouseActiveRadius );
        return this;
    }

    /**
     * @return the mouse active radius
     */
    public final Integer getMouseActiveRadius()
    {
        return getInteger( MOUSE_ACTIVE_RADIUS_KEY );
    }

    /**
     * Clear the mouse active radius
     */
    public final GridOptions clearMouseActiveRadius()
    {
        clear( MOUSE_ACTIVE_RADIUS_KEY );
        return this;
    }

    /**
     * @return the margin number
     */
    public final Double getMarginAsNumber()
    {
        return getDouble( MARGIN_KEY );
    }

    /**
     * @return the margin object
     */
    public final Margin getMarginAsObject()
    {
        return getJsObject( MARGIN_KEY );
    }

    /**
     * Set the space in pixels between the canvas edge and the grid
     */
    public final GridOptions setMargin( double margin )
    {
        put( MARGIN_KEY, margin );
        return this;
    }

    /**
     * Set the space in pixels between the canvas edge and the grid
     */
    public final GridOptions setMargin( Margin margin )
    {
        put( MARGIN_KEY, margin );
        return this;
    }

    /**
     * Clear the margin option
     */
    public final GridOptions clearMargin()
    {
        clear( MARGIN_KEY );
        return this;
    }

}
