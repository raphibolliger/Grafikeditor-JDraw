package jdraw.figures.figureHandels;

import jdraw.figures.AbstractFigureHandler;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

public class FigureHandleS extends AbstractFigureHandler {

    public FigureHandleS(Figure figure) {
        super(figure);
    }

    @Override
    public Point getLocation() {
        return new Point(((figure.getBounds().x)+figure.getBounds().width/2)-4, figure.getBounds().y-4+figure.getBounds().height);
    }

    @Override
    public Cursor getCursor() {
        return new Cursor(Cursor.S_RESIZE_CURSOR);
    }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {

        Rectangle rect = figure.getBounds();
        Point origin = new Point(rect.x, rect.y);
        Point corner = new Point(rect.x + rect.width, y);
        figure.setBounds(origin, corner);

    }
}
