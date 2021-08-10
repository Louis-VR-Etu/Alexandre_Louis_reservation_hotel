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
    private JMenuItem addReservation, listReservations, removeReservation, researchFreeRoom;
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
        removeReservation = new JMenuItem("Remove Member");
        removeReservation.addActionListener(new RemoveListener());
        reservationMenu.add(addReservation);
        reservationMenu.add(listReservations);
        reservationMenu.add(removeReservation);

        researchMenu = new JMenu("Researches");
        menuBar.add(researchMenu);
        researchFreeRoom = new JMenuItem("research free rooms");
        researchFreeRoom.addActionListener(new researchFreeRoomsListener());
        researchMenu.add(researchFreeRoom);


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

    private class RemoveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            container.removeAll();
            container.add(new RemovePanel(), BorderLayout.CENTER);
            container.repaint();
            ProgramWindow.this.setVisible(true);
        }
    }

    private class researchFreeRoomsListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            container.removeAll();
            container.add(new FreeRoomsPanel(), BorderLayout.CENTER);
            container.repaint();
            ProgramWindow.this.setVisible(true);
        }
    }
}
