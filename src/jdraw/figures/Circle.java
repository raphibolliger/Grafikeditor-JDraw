package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.*;
import java.util.List;

public class Circle implements Figure {

    Ellipse2D ellipse;
    private LinkedList<FigureListener> figureListeners = new LinkedList<>();

    public Circle()
    {
        ellipse = new Ellipse2D()
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
