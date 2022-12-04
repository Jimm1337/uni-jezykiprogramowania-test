package tb.soft.gui;

import tb.soft.gui.swing.Content;

public interface IWindow {
    IGui getManager();
    Content getContent();
}
