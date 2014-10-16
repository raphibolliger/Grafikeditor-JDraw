package jdraw.figures;

import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends AbstractFigure {

    private Line2D line;

    public Line(int x, int y) {
        this.line = new Line2D.Double(x, y, x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine((int)line.getX1(), (int)line.getY1(), (int)line.getX2(), (int)line.getY2());
        g.drawRect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
    }

    @Override
    public void move(int dx, int dy) {
        if (dx == 0 && dy == 0)
            return;

        line.setLine(line.getX1()+dx, line.getY1()+dy, line.getX2()+dx, line.getY2()+dy);
    }

    @Override
    public boolean contains(int x, int y) {
        return line.ptLineDist(x, y) <= 5;
    }

    @Override
    public void setBounds(Point origin, Point corner) {
        line.setLine(origin, corner);
        propagateFigureEvent();
    }

    @Override
    public Rectangle getBounds() {
        return line.getBounds();
    }
}
