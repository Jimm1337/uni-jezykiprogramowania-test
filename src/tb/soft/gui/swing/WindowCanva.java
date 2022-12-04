package tb.soft.gui.swing;

import tb.soft.gui.IGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WindowCanva extends WindowBase implements KeyListener, MouseListener {

    private static final String TITLE = "Canva";
    private static final String TEXT_KOLO = "Aktywne - Koło";
    private static final String TEXT_PROSTOKAT = "Aktywne - Prostokąt";

    private final JLabel activeInsert;
    private boolean isCircle;
    private final JLabel helpLabel = new JLabel("'K' - Koło, 'P' - Prostokąt");

    private final Graphics gfx = content.getGraphics();

    public WindowCanva(IGui manager) {
        super(manager, TITLE);
        setResizable(false);
        addKeyListener(this);
        addMouseListener(this);

        int yhelp = super.getHeight() - 65;
        content.addComponent(helpLabel, 0, yhelp);

        activeInsert = new JLabel(TEXT_PROSTOKAT);
        content.addComponent(activeInsert, 0, 0);

        isCircle = false;
    }

    @Override
    protected void setSize() {
        setSize(800, 600);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'k' -> {
                activeInsert.setText(TEXT_KOLO);
                isCircle = true;
            }
            case 'p' -> {
                activeInsert.setText(TEXT_PROSTOKAT);
                isCircle = false;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isCircle) {
            gfx.drawOval(e.getX() - 35, e.getY() - 60, 50, 50);
        } else {
            gfx.drawRect(e.getX() - 35, e.getY() - 60, 50, 50);
        }
    }

    //-------//

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
