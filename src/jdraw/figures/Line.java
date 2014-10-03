package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;
import java.util.List;

public class Line implements Figure {

    private Line2D.Double line;
    private LinkedList<FigureListener> figureListeners = new LinkedList<>();

    public Line(int x1, int y1, int x2, int y2)
    {
        line = new Line2D.Double(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine((int)line.x1, (int)line.y1, (int)line.x2, (int)line.y2);
    }

    @Override
    public void move(int dx, int dy) {
        if (dx == 0 && dy == 0)
            return;
        line.setLine(line.x1 + dx, line.y1 + dy, line.x2 + dx, line.y2 + dy);
    }

    @Override
    public boolean contains(int x, int y) {
        return line.contains(x, y);
    }

    @Override
    public void setBounds(Point origin, Point corner) {
        line.setLine(origin, corner);
        for (FigureListener l : figureListeners) l.figureChanged(new FigureEvent(this));
    }

    @Override
    public Rectangle getBounds() {
        return line.getBounds();
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
