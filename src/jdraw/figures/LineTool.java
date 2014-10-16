package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class LineTool extends AbstractDragDrawTool {

    public LineTool(DrawContext context, String name, String icon) {
        super(context, name, icon);
    }

    @Override
    protected Figure createFigure(Point p) {
        return new Line(p.x, p.y);
    }
}
