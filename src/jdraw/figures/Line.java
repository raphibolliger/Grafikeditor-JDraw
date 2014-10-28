package jdraw.figures;

import jdraw.figures.figureHandels.FigureHandleLine;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Line extends AbstractFigure {

    private Point origin;
    private Point corner;

    public Line(int x, int y) {
        this.origin = new Point(x, y);
        this.corner = new Point(x, y);

        setFigureHandles(new FigureHandleLine(this));
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.BLACK);
        g.drawLine(origin.x, origin.y, corner.x, corner.y);

        g.setColor(Color.BLUE);
        // für Test zeichne den Rahmen der Linie
        g.drawRect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
    }

    @Override
    public void move(int dx, int dy) {
        if (dx == 0 && dy == 0)
            return;

        this.origin.x += dx;
        this.origin.y += dy;
        this.corner.x += dx;
        this.corner.y += dy;

        propagateFigureEvent();
    }

    @Override
    public boolean contains(int x, int y) {
        Line2D line = new Line2D.Double(origin.x, origin.y, corner.x, corner.y);
        return line.ptLineDist(x, y) <= 5;
    }

    @Override
    public void setBounds(Point origin, Point corner) {

        this.origin = origin;
        this.corner = corner;

        propagateFigureEvent();
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(0, 0, 0 ,0);
    }
}
