package jdraw.figures.figureHandels;

import jdraw.figures.AbstractFigureHandler;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

public class FigureHandleSW extends AbstractFigureHandler {

    public FigureHandleSW(Figure figure) {
        super(figure);
    }

    @Override
    public Point getLocation() {
        return new Point(figure.getBounds().x-4, figure.getBounds().y-4+figure.getBounds().height);
    }

    @Override
    public Cursor getCursor() {
        return new Cursor(Cursor.SW_RESIZE_CURSOR);
    }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {

        Rectangle rect = figure.getBounds();
        Point origin = new Point(x, rect.y);
        Point corner = new Point(rect.x + rect.width, y);
        figure.setBounds(origin, corner);

    }
}
