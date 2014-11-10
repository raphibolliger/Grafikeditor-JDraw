package jdraw.framework;

import java.awt.*;

public abstract class AbstractPointConstrainer implements PointConstrainer {

    private DrawContext context;
    private String name;

    public AbstractPointConstrainer(DrawContext context, String name) {
        this.context = context;
        this.name = name;
    }

    @Override
    public abstract Point constrainPoint(Point p);

    @Override
    public abstract int getStepX(boolean right);

    @Override
    public abstract int getStepY(boolean down);

    @Override
    public void activate() {
        context.showStatusText(name + " is active.");
    }

    @Override
    public void deactivate() {
        context.showStatusText("");
    }

    @Override
    public abstract void mouseDown();

    @Override
    public abstract void mouseUp();
}
