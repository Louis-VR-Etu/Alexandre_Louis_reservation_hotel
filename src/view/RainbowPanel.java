package view;

import model.RainbowThread;
import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;

public class RainbowPanel extends JPanel{
    private JLabel rainbowWord;
    private RainbowThread rainbowThread;
    private Color currentColor;
    private String currentColorString;

    public RainbowPanel() {
        this.setLayout(new GridLayout(0, 1, 5, 5));
        setColors();
        rainbowWord = new JLabel("Rainbow Word");
        this.add(rainbowWord);
        rainbowThread = new RainbowThread(this);
        rainbowThread.start();
    }

    public void setColors() {
        currentColor = BLACK;
        currentColorString = "BLACK";
    }

    public void changeColor() {
        switch (currentColorString) {
            case "BLACK" -> {
                currentColor = RED;
                currentColorString = "RED";
            }
            case "RED" -> {
                currentColor = ORANGE;
                currentColorString = "ORANGE";
            }
            case "ORANGE" -> {
                currentColor = YELLOW;
                currentColorString = "YELLOW";
            }
            case "YELLOW" -> {
                currentColor = GREEN;
                currentColorString = "GREEN";
            }
            case "GREEN" -> {
                currentColor = BLUE;
                currentColorString = "BLUE";
            }
            case "BLUE" -> {
                currentColor = new Color(102, 0, 153);
                currentColorString = "PURPLE";
            }
            case "PURPLE" -> {
                currentColor = BLACK;
                currentColorString = "BLACK";
            }
            default -> {
                currentColor = RED;
                currentColorString = "RED";
            }
        }
        rainbowWord.setForeground(currentColor);
        RainbowPanel.this.removeAll();
        RainbowPanel.this.add(rainbowWord);
        RainbowPanel.this.repaint();
        RainbowPanel.this.setVisible(true);
    }
}
