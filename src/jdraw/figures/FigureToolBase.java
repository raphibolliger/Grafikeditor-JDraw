package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class FigureToolBase<T extends FigureBase> implements DrawTool {

    private static final String IMAGES = "/images/";
    private String figureName;
    private DrawContext context;
    private DrawView view;

    protected T newFigure = null;
    protected Point anchor = null;

    public FigureToolBase(DrawContext context, String figureName) {
        this.context = context;
        this.view = context.getView();
        this.figureName = figureName;
    }

    @Override
    public void activate() {
        this.context.showStatusText(figureName + " Mode");
    }

    @Override
    public void deactivate() {
        this.context.showStatusText("");
    }

    @Override
    public void mouseDown(int x, int y, MouseEvent e) {
        
    }

    @Override
    public void mouseDrag(int x, int y, MouseEvent e) {

    }

    @Override
    public void mouseUp(int x, int y, MouseEvent e) {

    }

    @Override
    public Cursor getCursor() {
        return null;
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
