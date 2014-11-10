package jdraw.figures;

import jdraw.figures.figureHandels.*;
import jdraw.framework.Figure;
import jdraw.framework.FigureGroup;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class GroupFigure extends AbstractFigure implements FigureGroup {

    private LinkedList<Figure> groupedFigures;

    public GroupFigure(List<Figure> selectedFigures) {
        if (selectedFigures == null || selectedFigures.size() <= 0)
            throw new IllegalArgumentException();
        this.groupedFigures = new LinkedList<Figure>(selectedFigures);

        setFigureHandles(new FigureHandleNW(this));
        setFigureHandles(new FigureHandleN(this));
        setFigureHandles(new FigureHandleNE(this));
        setFigureHandles(new FigureHandleE(this));
        setFigureHandles(new FigureHandleSE(this));
        setFigureHandles(new FigureHandleS(this));
        setFigureHandles(new FigureHandleSW(this));
        setFigureHandles(new FigureHandleW(this));


    }

    @Override
    public void draw(Graphics g) {
        for (Figure f : groupedFigures) {
            f.draw(g);
        }
    }

    @Override
    public void move(int dx, int dy) {
        if (dx != 0 || dy != 0) {
            for (Figure l : groupedFigures) {
                l.move(dx, dy);
                propagateFigureEvent();
            }
        }
    }

    @Override
    public boolean contains(int x, int y) {
        for (Figure l : groupedFigures) {
            if (l.contains(x, y)) return true;
        }
        return false;
    }

    @Override
    public void setBounds(Point origin, Point corner) {

    }

    @Override
    public Rectangle getBounds() {
        Rectangle bounds = null;
        for (Figure f : groupedFigures) {
            if (bounds == null) { bounds = f.getBounds(); }
            else { bounds.add(f.getBounds()); }
        }
        return bounds;
    }

    @Override
    public Iterable<Figure> getFigureParts() {
        return Collections.unmodifiableList(groupedFigures);
    }
}
