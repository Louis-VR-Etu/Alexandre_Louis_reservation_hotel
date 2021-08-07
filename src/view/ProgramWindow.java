package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProgramWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu reservationMenu, researchMenu;
    private JMenuItem addReservation, listReservations;
    private Container container;

    public ProgramWindow(){
        super("JavaProject");
        container = this.getContentPane();
        setBounds(550,150,500,500);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        reservationMenu = new JMenu("Reservations Management");
        menuBar.add(reservationMenu);
        addReservation = new JMenuItem("Add Reservation");
        addReservation.addActionListener(new FormListener());
        listReservations = new JMenuItem("List Reservations");
        listReservations.addActionListener(new ListListener());
        reservationMenu.add(addReservation);
        reservationMenu.add(listReservations);

        researchMenu = new JMenu("Researches");
        menuBar.add(researchMenu);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    private class FormListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            container.removeAll();
            container.add(new FormPanel(), BorderLayout.CENTER);
            container.repaint();
            ProgramWindow.this.setVisible(true);
        }
    }

    private class ListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            container.removeAll();
            container.add(new AllReservationsPanel(), BorderLayout.CENTER);
            container.repaint();
            ProgramWindow.this.setVisible(true);
        }
    }

}
