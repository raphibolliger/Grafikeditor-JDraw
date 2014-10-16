package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.util.*;
import java.util.List;

public abstract class AbstractFigure implements Figure {

    private List<FigureListener> figureListeners = new LinkedList<>();

    @Override
    public void addFigureListener(FigureListener listener) {
        if (figureListeners == null) throw new IllegalArgumentException();
        if (!figureListeners.contains(listener)) {
            figureListeners.add(listener);
        }
    }

    @Override
    public void removeFigureListener(FigureListener listener) {
        figureListeners.remove(figureListeners);
    }

    @Override
    public Figure clone() {
        return null;
    }

    @Override
    public List<FigureHandle> getHandles() {
        return null;
    }

    protected void probagateFigureEvent(){
        FigureEvent fe = new FigureEvent(this);
        FigureListener[] copy = figureListeners.toArray(new FigureListener[figureListeners.size()]);
        for (FigureListener l : copy) l.figureChanged(fe);
    }

}