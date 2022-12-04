package tb.soft.gui.swing;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    private static final Insets GAPS = new Insets(10, 10, 10, 10);

    private final Window owner;

    public Content(Window owner) {
        super(null);
        this.owner = owner;

        setBorder(BorderFactory.createEmptyBorder(GAPS.top, GAPS.left, GAPS.bottom, GAPS.right));
        setBackground(Color.WHITE);
    }

    public void addComponent(Component component, int x, int y) {
        super.add(component);
        Dimension size = component.getPreferredSize();
        component.setBounds(x, y, size.width + GAPS.left, size.height + GAPS.top);
    }

    public void addComponent(Component component, int x, int y, int width, int height) {
        super.add(component);
        component.setBounds(x, y, width, height);
    }

    public void moveComponent(Component component, int x, int y) {
        component.setLocation(x, y);
    }

    @Override
    public Point getMousePosition() {
        Point mouse = MouseInfo.getPointerInfo().getLocation();
        Point window = owner.getLocationOnScreen();
        Point position = new Point(mouse.x - window.x, mouse.y - window.y);
        System.out.println(position);
        return position;
    }


    //---------//

    @Deprecated
    @Override
    public Component add(Component component) {
        throw new UnsupportedOperationException("Use addComponent() instead");
    }

    @Deprecated
    @Override
    public Component add(Component component, int index) {
        throw new UnsupportedOperationException("Use addComponent() instead");
    }

    @Deprecated
    @Override
    public void add(Component component, Object constraints) {
        throw new UnsupportedOperationException("Use addComponent() instead");
    }

    @Deprecated
    @Override
    public void add(Component component, Object constraints, int index) {
        throw new UnsupportedOperationException("Use addComponent() instead");
    }

    @Deprecated
    @Override
    public Component add(String name, Component component) {
        throw new UnsupportedOperationException("Use addComponent() instead");
    }

    @Deprecated
    @Override
    public void add(PopupMenu popup) {
        throw new UnsupportedOperationException("Use addComponent() instead");
    }
}
