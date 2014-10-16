package jdraw.figures;

import java.awt.*;

public abstract class AbstractRectangularFigure extends AbstractFigure {

    private Rectangle rectangle = null;

    protected AbstractRectangularFigure(Point origin) {
        rectangle = new Rectangle(origin);
    }

    @Override
    public void setBounds(Point origin, Point corner) {
        Rectangle original = new Rectangle(rectangle);
        rectangle.setFrameFromDiagonal(origin, corner);
        if (!original.equals(rectangle)) {
            probagateFigureEvent();
        }
    }

    @Override
    public void move(int dx, int dy) {
        if (dx != 0 | dy != 0) {
            rectangle.translate(dx, dy);
            probagateFigureEvent();
        }
    }

    @Override
    public boolean contains(int x, int y) {
        return rectangle.contains(x, y);
    }

}
