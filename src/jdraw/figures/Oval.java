package jdraw.figures;

import jdraw.figures.figureHandels.*;

import java.awt.*;

public class Oval extends AbstractRectangularFigure {

    public Oval(Point origin, int w, int h) {
        super(origin, w, h);
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
        g.fillOval(r.x, r.y, r.width, r.height);

        g.setColor(Color.black);
        g.drawOval(r.x, r.y, r.width, r.height);
    }
}
