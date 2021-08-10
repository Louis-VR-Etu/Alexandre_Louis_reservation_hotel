package view;

import model.RainbowThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.*;

public class RainbowPanel extends JPanel{
    private JLabel rainbowWord;
    private JButton validationButton;
    private RainbowThread rainbowThread;
    private ArrayList<Color> colors;
    private Color currentColor;
    private String currentColorString;

    public RainbowPanel() {
        this.setLayout(new GridLayout(1, 1, 5, 5));

        setColors();
        rainbowWord = new JLabel("Rainbow Word");
        this.add(rainbowWord);
        rainbowThread = new RainbowThread(this);
        rainbowThread.start();
    }

    public void setColors() {
        colors = new ArrayList<>();
        colors.add(RED);
        colors.add(ORANGE);
        colors.add(YELLOW);
        colors.add(GREEN);
        colors.add(BLUE);
        colors.add(new Color (102, 0, 153));
        currentColor = BLACK;
        currentColorString = "BLACK";
    }

    public void changeColor() {
        switch (currentColorString) {
            case "BLACK": currentColor = RED;
                currentColorString = "RED";
                break;
            case "RED": currentColor = ORANGE;
                currentColorString = "ORANGE";
                break;
            case "ORANGE": currentColor = YELLOW;
                currentColorString = "YELLOW";
                break;
            case "YELLOW": currentColor = GREEN;
                currentColorString = "GREEN";
                break;
            case "GREEN": currentColor = BLUE;
                currentColorString = "BLUE";
                break;
            case "BLUE": currentColor = new Color (102, 0, 153);
                currentColorString = "PURPLE";
                break;
            case "PURPLE": currentColor = RED;
                currentColorString = "RED";
                break;
            default: currentColor = RED;
                currentColorString = "RED";
                break;
        }
        rainbowWord.setForeground(currentColor);
        RainbowPanel.this.removeAll();
        RainbowPanel.this.add(rainbowWord);
        RainbowPanel.this.repaint();
        RainbowPanel.this.setVisible(true);
    }
}
