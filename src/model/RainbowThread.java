package model;

import view.RainbowPanel;
import javax.swing.*;

public class RainbowThread extends Thread{
    private RainbowPanel rainbowPanel;

    public RainbowThread(RainbowPanel rainbowPanel){
        this.rainbowPanel = rainbowPanel;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(3000);
                rainbowPanel.changeColor();
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
