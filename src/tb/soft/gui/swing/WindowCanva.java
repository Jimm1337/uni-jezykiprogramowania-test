package tb.soft.gui.swing;

import tb.soft.gui.IGui;

public class WindowCanva extends WindowBase {
    public WindowCanva(IGui manager) {
        super(manager, "Canva");
    }

    @Override
    protected void setSize() {
        setSize(800, 600);
    }
}
