package jdraw.framework;

import java.awt.*;

public class NumberPointConstrainer extends AbstractPointConstrainer {

    private int stepX;
    private int stepY;

    public NumberPointConstrainer(DrawContext context, String name, int stepX, int stepY) {
        super(context, name);
        this.stepX = stepX;
        this.stepY = stepY;
    }

    @Override
    public Point constrainPoint(Point p) {
        p.x = (p.x / stepX) * stepX;
        p.y = (p.y / stepY) * stepY;
        return p;
    }

    @Override
    public int getStepX(boolean right) {
        return stepX;
    }

    @Override
    public int getStepY(boolean down) {
        return stepY;
    }

    @Override
    public void mouseDown() {

    }

    @Override
    public void mouseUp() {

    }
}
