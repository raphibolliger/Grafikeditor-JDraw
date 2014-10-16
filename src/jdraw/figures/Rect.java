/*
 * Copyright (c) 2000-2014 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import jdraw.figures.figureHandels.*;

import java.awt.*;

public class Rect extends AbstractRectangularFigure {

    public Rect(int x, int y) {
        super(new Point(x, y), 0, 0);
        setFigureHandles(new FigureHandleNW(this));
        setFigureHandles(new FigureHandleN(this));
        setFigureHandles(new FigureHandleNE(this));
        setFigureHandles(new FigureHandleE(this));
        setFigureHandles(new FigureHandleSE(this));
        setFigureHandles(new FigureHandleS(this));
        setFigureHandles(new FigureHandleSW(this));
        setFigureHandles(new FigureHandleW(this));
    }

    @Override
    public void draw(Graphics g) {

        Rectangle r = getBounds();

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(r.x, r.y, r.width, r.height);

        g.setColor(Color.black);
        g.drawRect(r.x, r.y, r.width, r.height);
    }

}
