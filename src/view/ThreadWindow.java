package view;

import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadWindow extends JFrame{
    private Container container;
    private JLabel rainbowWord;
    private JButton validationButton;
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
