package jdraw.figures;

import java.awt.*;

public class Oval extends AbstractRectangularFigure {

    public Oval(Point origin, int w, int h) {
        super(origin, w, h);
    }

    @Override
    public void draw(Graphics g) {
        Rectangle r = getBounds();
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(r.x, r.y, r.width, r.height);

        g.setColor(Color.black);
        g.drawOval(r.x, r.y, r.width, r.height);
    }
}
