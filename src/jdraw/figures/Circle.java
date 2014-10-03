package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Circle implements Figure {

    java.awt.geom.Ellipse2D.Double ellipse;
    private LinkedList<FigureListener> figureListeners = new LinkedList<>();

    public Circle(int x, int y, int r)
    {
        ellipse = new java.awt.geom.Ellipse2D.Double(x, y, r, r);
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }

    @Override
    public void setBounds(Point origin, Point corner) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public List<FigureHandle> getHandles() {
        return null;
    }

    @Override
    public void addFigureListener(FigureListener listener) {

    }

    @Override
    public void removeFigureListener(FigureListener listener) {

    }

    @Override
    public Figure clone() {
        return null;
    }
}
