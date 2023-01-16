package tb.soft.gui.swing;

import tb.soft.features.SquareFalling;
import tb.soft.gui.IGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WindowCanva extends WindowBase implements MouseListener {

    private static final String TITLE = "Canva";

    private final Graphics gfx = content.getGraphics();
    private Point newSquareLeftTop;
    private Point newSquareRightBottom;

    public WindowCanva(IGui manager) {
        super(manager, TITLE);
        setResizable(false);
        addMouseListener(this);
        gfx.setColor(Color.BLACK);
    }

    @Override
    protected void setSize() {
        setSize(800, 600);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        newSquareLeftTop = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        newSquareRightBottom = e.getPoint();
        new SquareFalling(
                new Dimension(newSquareRightBottom.x - newSquareLeftTop.x,
                        newSquareRightBottom.y - newSquareLeftTop.y),
                new Dimension(newSquareLeftTop.x, newSquareLeftTop.y), gfx, getHeight()).start();
    }

    //-------//

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
