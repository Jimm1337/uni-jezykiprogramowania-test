package tb.soft.features;

import javax.swing.*;
import java.awt.*;

public class SquareFalling extends Thread {
    private static final int SPEED = 5;
    private static final int DELAY = 50;
    private final Dimension size;
    private Dimension position;
    private volatile boolean collided;
    private final Graphics gfx;
    private final int bound;

    public SquareFalling(Dimension size, Dimension initialPosition, Graphics gfx, int bound) {
        this.size = size;
        this.position = initialPosition;
        this.gfx = gfx;
        this.bound = bound;
        collided = false;
    }

    @Override
    public void run() {
        while (!collided && position.height + size.height * 1.5 <= bound) {
            Thread.onSpinWait();
            try {
                drawSquare();
                Thread.sleep(DELAY);
                eraseSquare();
                position.height += SPEED;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        eraseSquare();
        drawSquare();
    }

    private void drawSquare() {
        gfx.drawRect(position.width, position.height, size.width, size.height);
    }

    private void eraseSquare() {
        gfx.setColor(Color.WHITE);
        gfx.fillRect(position.width, position.height, size.width+2, size.height+2);
        gfx.setColor(Color.BLACK);
    }

    public void setCollided(boolean collided) {
        this.collided = collided;
    }

    public Dimension getPosition() {
        return position;
    }
}
