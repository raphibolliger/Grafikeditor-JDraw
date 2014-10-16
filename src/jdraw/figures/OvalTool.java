package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class OvalTool extends AbstractDragDrawTool {

    public OvalTool(DrawContext context, String name, String icon) {
        super(context, name, icon);
    }

    @Override
    protected Figure createFigure(Point p) {
        return new Oval(p, 0, 0);
    }
}
