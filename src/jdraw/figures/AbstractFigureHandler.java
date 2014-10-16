package jdraw.figures;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class AbstractFigureHandler implements FigureHandle {

    protected Figure figure;

    public AbstractFigureHandler(Figure figure) {
        this.figure = figure;
    }

    @Override
    public Figure getOwner() {
        return figure;
    }

    @Override
    public abstract Point getLocation();

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(getLocation().x, getLocation().y, 8, 8);
        g.setColor(Color.BLACK);
        g.drawRect(getLocation().x, getLocation().y, 8, 8);
    }

    @Override
    abstract public Cursor getCursor();

    @Override
    public boolean contains(int x, int y) {
        Rectangle rect = new Rectangle(getLocation().x, getLocation().y, 8 , 8);
        return rect.contains(x, y);
    }

    @Override
    public void startInteraction(int x, int y, MouseEvent e, DrawView v) {

    }

    @Override
    public abstract void dragInteraction(int x, int y, MouseEvent e, DrawView v);

    @Override
    public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {

    }

}
