/*
 * Copyright (c) 2000-2013 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.Iterator;
import java.util.LinkedList;

import jdraw.framework.*;

/**
 * Provide a standard behavior for the drawing model. This class initially does not implement the methods
 * in a proper way.
 * It is part of the course assignments to do so.
 * @author TODO add your name here
 *
 */
public class StdDrawModel implements DrawModel, FigureListener {

    private LinkedList<Figure> figures = new LinkedList<>();
    private LinkedList<DrawModelListener> drawModelListeners = new LinkedList<>();


	@Override
	public void addFigure(Figure f) {

        if (!figures.contains(f)) {
            f.addFigureListener(this);
            figures.add(f);
            for (DrawModelListener l : drawModelListeners) l.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_ADDED));
        }
	}

	@Override
	public Iterable<Figure> getFigures() {
        return figures;
	}

	@Override
	public void removeFigure(Figure f) {

        if (figures.contains(f)) {
            f.removeFigureListener(this);
            figures.remove(f);
            for(DrawModelListener l : drawModelListeners) l.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_REMOVED));
        }

	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {
		drawModelListeners.add(listener);
	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
		drawModelListeners.remove(listener);
	}

	/** The draw command handler. Initialized here with a dummy implementation. */
	// TODO initialize with your implementation of the undo/redo-assignment.
	private DrawCommandHandler handler = new EmptyDrawCommandHandler();

	/**
	 * Retrieve the draw command handler in use.
	 * @return the draw command handler.
	 */
	public DrawCommandHandler getDrawCommandHandler() {
		return handler;
	}

	@Override
	public void setFigureIndex(Figure f, int index) {
        if (!figures.contains(f))
            throw new IllegalArgumentException("figure dosen't exist!");
        if (index > figures.size())
            throw new ArrayIndexOutOfBoundsException("figure index doesn't exist");

        figures.remove(f);
        figures.add(index, f);
        for(DrawModelListener l : drawModelListeners) l.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.DRAWING_CHANGED));

	}

	@Override
	public void removeAllFigures() {
        Iterator<Figure> it = figures.iterator();
        while (it.hasNext()) it.next().removeFigureListener(this);
        figures.clear();
        for(DrawModelListener l : drawModelListeners) l.modelChanged(new DrawModelEvent(this, null, DrawModelEvent.Type.DRAWING_CLEARED));
	}

    @Override
    public void figureChanged(FigureEvent e) {
        for(DrawModelListener l : drawModelListeners) l.modelChanged(new DrawModelEvent(this, e.getFigure(), DrawModelEvent.Type.FIGURE_CHANGED));
    }
}
