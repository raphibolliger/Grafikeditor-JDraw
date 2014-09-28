/*
 * Copyright (c) 2000-2013 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

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
        f.addFigureListener(this);
        figures.add(f);
        System.out.println("Figure added");
        for(DrawModelListener l : drawModelListeners) l.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_ADDED));
	}

	@Override
	public Iterable<Figure> getFigures() {
        return figures;
		//System.out.println("StdDrawModel.getFigures has to be implemented");
	}

	@Override
	public void removeFigure(Figure f) {
        figures.remove(f);
        for(DrawModelListener l : drawModelListeners) l.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_REMOVED));
		System.out.println("Figure removed");
	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {
		drawModelListeners.add(listener);
		//System.out.println("StdDrawModel.addModelChangeListener has to be implemented");
	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
		drawModelListeners.remove(listener);
		//System.out.println("StdDrawModel.removeModelChangeListener has to be implemented");
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
		// TODO to be implemented
		System.out.println("StdDrawModel.setFigureIndex has to be implemented");
	}

	@Override
	public void removeAllFigures() {
		// TODO to be implemented  
		System.out.println("StdDrawModel.removeAllFigures has to be implemented");
	}

    @Override
    public void figureChanged(FigureEvent e) {
        for(DrawModelListener l : drawModelListeners) l.modelChanged(new DrawModelEvent(this, e.getFigure(), DrawModelEvent.Type.FIGURE_CHANGED));
    }
}
