package tb.soft.features;

import tb.soft.gui.IGui;
import tb.soft.gui.IWindow;
import tb.soft.gui.swing.WindowCanva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.Serial;

public class RunningButton extends JButton implements MouseListener {
    @Serial
    private static final long serialVersionUID = 1L;

    private final IWindow owner;

    public RunningButton(IWindow owner) {
        super("Running");
        this.owner = owner;
        addMouseListener(this);
        addActionListener(this::eventClick);
    }

    public void eventClick(java.awt.event.ActionEvent event) {
        IGui gui = owner.getManager();
        gui.flow(new WindowCanva(gui));
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        var content = owner.getContent();
        var currentLocation = getLocation();
        var point = e.getPoint();
        var contentSize = content.getSize();
        var gaps = new Dimension(20, 20);

        int x, y;

        if (point.x < getWidth() / 2) {
            x = currentLocation.x + 10;
            if (x > contentSize.width - getWidth() - gaps.width) {
                x = currentLocation.x;
            }
        } else {
            x = currentLocation.x - 10;
            if (x < gaps.width) {
                x = currentLocation.x;
            }
        }

        if (point.y < getHeight() / 2) {
            y = currentLocation.y + 10;
            if (y > contentSize.height - getHeight() - gaps.height) {
                y = currentLocation.y;
            }
        } else {
            y = currentLocation.y - 10;
            if (y < gaps.height) {
                y = currentLocation.y;
            }
        }

        content.moveComponent(this, x, y);
    }


    //--------//

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }
}
