package view;

import javax.swing.*;
import java.awt.*;

public class ThreadWindow extends JFrame{
    private Container container;
    private RainbowPanel rainbowPanel;

    public ThreadWindow() {
        super("Rainbow word");
        container = this.getContentPane();
        setBounds(550,150,600,600);
        rainbowPanel = new RainbowPanel();
        container.add(rainbowPanel);
        this.setVisible(true);
    }
}
