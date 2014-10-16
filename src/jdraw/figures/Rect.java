/*
 * Copyright (c) 2000-2014 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import java.awt.*;

public class Rect extends AbstractRectangularFigure {

    public Rect(int x, int y) {
        super(new Point(x, y), 0, 0);
    }

    @Override
    public void draw(Graphics g) {

        Rectangle r = getBounds();

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(r.x, r.y, r.width, r.height);

        g.setColor(Color.black);
        g.drawRect(r.x, r.y, r.width, r.height);
    }

}
