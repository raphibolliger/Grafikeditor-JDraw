/*
 * Copyright (c) 2000-2014 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import java.awt.Point;

import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

public class RectTool extends AbstractDragDrawTool {

    public RectTool(DrawContext context, String name, String icon) {
        super(context, name, icon);
    }

    @Override
    protected Figure createFigure(Point p) {
        return new Rect(p.x, p.y);
    }
}
