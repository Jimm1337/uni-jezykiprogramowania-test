package tb.soft.gui.swing;

import tb.soft.features.RunningButton;
import tb.soft.gui.IGui;

public class WindowButton extends WindowBase {
    private final RunningButton button;

    public WindowButton(IGui manager) {
        super(manager, "Przycisk");

        this.button = new RunningButton(this);
        content.addComponent(button, 200, 200);
    }

    @Override
    protected void setSize() {
        setSize(800, 600);
    }
}
