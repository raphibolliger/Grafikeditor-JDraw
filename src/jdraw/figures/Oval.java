package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Oval implements Figure {

    java.awt.geom.Ellipse2D.Double oval;
    private LinkedList<FigureListener> figureListeners = new LinkedList<>();

    public Oval(int x, int y, int w, int h)
    {
        oval = new java.awt.geom.Ellipse2D.Double(x, y, w, h);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int) oval.x, (int) oval.y, (int) oval.width, (int) oval.height);

        g.setColor(Color.BLACK);
        g.drawOval((int) oval.x, (int) oval.y, (int) oval.width, (int) oval.height);
    }

    @Override
    public void move(int dx, int dy) {
        if (dx == 0 && dy == 0)
            return;
        oval.setFrame(oval.x + dx, oval.y + dy, oval.width + dx, oval.height + dy);
        for(FigureListener l : figureListeners) l.figureChanged(new FigureEvent(this));
    }

    @Override
    public boolean contains(int x, int y) {
        return oval.contains(x, y);
    }

    @Override
    public void setBounds(Point origin, Point corner) {
        oval.setFrameFromDiagonal(origin, corner);
        for (FigureListener l : figureListeners) l.figureChanged(new FigureEvent(this));
    }

    @Override
    public Rectangle getBounds() {
        return oval.getBounds();
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
