package jdraw.figures.figureHandels;

import jdraw.figures.AbstractFigureHandler;
import jdraw.figures.Rect;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

public class FigureHandleLine extends AbstractFigureHandler {

    public FigureHandleLine(Figure figure) {
        super(figure);
    }

    @Override
    public Point getLocation() {
        return new Point(figure.getBounds().x, figure.getBounds().y);
    }

    public Point getEndLocation() {
        return new Point(figure.getBounds().x + figure.getBounds().width, figure.getBounds().y + figure.getBounds().height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(getLocation().x, getLocation().y, 8, 8);
        g.fillRect(getEndLocation().x, getEndLocation().y, 8, 8);
        g.setColor(Color.BLACK);
        g.drawRect(getLocation().x, getLocation().y, 8, 8);
        g.drawRect(getEndLocation().x, getEndLocation().y, 8, 8);
    }

    @Override
    public boolean contains(int x, int y) {
        Rectangle rect = new Rectangle(getEndLocation().x, getEndLocation().y, 8 , 8);
        return super.contains(x, y) || rect.contains(x, y);
    }

    @Override
    public Cursor getCursor() {
        return new Cursor(Cursor.HAND_CURSOR);
    }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {

        Point origin = getLocation();
        Point corner = getEndLocation();
        figure.setBounds(new Point(x, y), corner);



    }
}
