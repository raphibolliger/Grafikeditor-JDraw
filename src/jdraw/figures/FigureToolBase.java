package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

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
        if (newFigure != null)
        {
            throw new IllegalStateException();
        }
        anchor = new Point(x, y);
        newFigure = instanceNewFigure(x, y);
        view.getModel().addFigure(newFigure);
    }

    abstract T instanceNewFigure(int x, int y);

    @Override
    public void mouseDrag(int x, int y, MouseEvent e) {
        newFigure.setBounds(anchor, new Point(x, y));
        java.awt.Rectangle r = newFigure.getBounds();
        this.context.showStatusText("w: " + r.width + ", h: " + r.height);
    }

    @Override
    public void mouseUp(int x, int y, MouseEvent e) {
        newFigure = null;
        anchor = null;
        this.context.showStatusText(figureName + " Mode");
    }

    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
    }

    @Override
    public Icon getIcon() {
        return new ImageIcon(getClass().getResource(IMAGES + figureName.toLowerCase() + ".png"));
    }

    @Override
    public String getName() {
        return figureName;
    }
}
