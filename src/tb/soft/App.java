package tb.soft;

import tb.soft.gui.IGui;
import tb.soft.gui.swing.GuiManager;

public class App implements Runnable, IApp {
    private final IGui gui;

    public App() {
        gui = new GuiManager(this);
    }

    @Override
    public void run() {
        gui.entry();
    }
}
