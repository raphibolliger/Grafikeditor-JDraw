package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.awt.geom.RectangularShape;
import java.util.LinkedList;
import java.util.List;

public abstract class FigureBase<T extends Shape> implements Figure {

    private T figure;
    private LinkedList<FigureListener> figureListeners;

    @Override
    public abstract void draw(Graphics g);

    @Override
    public abstract void move(int dx, int dy);

    @Override
    public boolean contains(int x, int y) {
        return figure.contains(x, y);
    }

    // Has to be implemented every time is different for a line or for a rectangle
    @Override
    public abstract void setBounds(Point origin, Point corner);

    @Override
    public Rectangle getBounds() {
        return figure.getBounds();
    }

    @Override
    public List<FigureHandle> getHandles() {
        return null;
    }

    @Override
    public void addFigureListener(FigureListener listener) {
        figureListeners.add(listener);
    }

    @Override
    public void removeFigureListener(FigureListener listener) {
        figureListeners.remove(listener);
    }

    @Override
    public Figure clone() {
        return null;
    }
}
