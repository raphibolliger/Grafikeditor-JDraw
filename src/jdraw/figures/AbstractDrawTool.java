package jdraw.figures;

import jdraw.framework.DrawTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class AbstractDrawTool implements DrawTool {

    private static final String IMAGES = "/images/";
    private String name;
    private String icon;

    protected AbstractDrawTool(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final Icon getIcon() {
        if (icon != null) {
            return new ImageIcon(getClass().getResource(IMAGES+icon));
        } else {
            return null;
        }
    }

    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
    }

    @Override
    abstract public void activate();

    @Override
    abstract public void deactivate();

    @Override
    abstract public void mouseUp(int x, int y, MouseEvent e);

    @Override
    abstract public void mouseDrag(int x, int y, MouseEvent e);

    @Override
    abstract public void mouseDown(int x, int y, MouseEvent e);
}
