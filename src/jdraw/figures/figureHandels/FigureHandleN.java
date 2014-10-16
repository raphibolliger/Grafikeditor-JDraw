package jdraw.figures.figureHandels;

import jdraw.figures.AbstractFigureHandler;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

public class FigureHandleN extends AbstractFigureHandler {

    public FigureHandleN(Figure figure) {
        super(figure);
    }

    @Override
    public Point getLocation() {
        return new Point(((figure.getBounds().x)+figure.getBounds().width/2)-4, figure.getBounds().y-4);
    }

    @Override
    public Cursor getCursor() {
        return new Cursor(Cursor.N_RESIZE_CURSOR);
    }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {

        Rectangle rect = figure.getBounds();
        Point origin = new Point(rect.x, y);
        Point corner = new Point(rect.x + rect.width, rect.y + rect.height);
        figure.setBounds(origin, corner);

    }
}
