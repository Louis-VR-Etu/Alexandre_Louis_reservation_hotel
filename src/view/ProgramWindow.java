package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProgramWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu reservationMenu, researchMenu, taskMenu;
    private JMenuItem addReservation, listReservations, removeReservation,updateReservation, researchFreeRoom, researchHotelCustomers, researchCustomerReservations, reservationPrice;
    private Container container;
    private ThreadWindow threadWindow;

    public ProgramWindow(){
        super("JavaProject");
        container = this.getContentPane();
        setBounds(550,150,500,500);
        threadWindow = new ThreadWindow();
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        reservationMenu = new JMenu("Reservations Management");
        menuBar.add(reservationMenu);
        addReservation = new JMenuItem("Add Reservation");
        addReservation.addActionListener(new FormListener());
        listReservations = new JMenuItem("List Reservations");
        listReservations.addActionListener(new ListListener());
        removeReservation = new JMenuItem("Remove Reservation");
        removeReservation.addActionListener(new RemoveListener());
        updateReservation = new JMenuItem("Update Reservation");
        updateReservation.addActionListener(new UpdateListener());
        reservationMenu.add(listReservations);
        reservationMenu.add(addReservation);
        reservationMenu.add(updateReservation);
        reservationMenu.add(removeReservation);

        researchMenu = new JMenu("Researches");
        menuBar.add(researchMenu);
        researchFreeRoom = new JMenuItem("research free rooms");
        researchFreeRoom.addActionListener(new researchFreeRoomsListener());
        researchMenu.add(researchFreeRoom);
        researchHotelCustomers = new JMenuItem("research Hotel Customers");
        researchHotelCustomers.addActionListener(new researchHotelCustomersListener());
        researchMenu.add(researchHotelCustomers);
        researchCustomerReservations = new JMenuItem("research Customer Hotels");
        researchCustomerReservations.addActionListener(new researchCustomerReservationsListener());
        researchMenu.add(researchCustomerReservations);

        taskMenu = new JMenu("Job Tasks");
        menuBar.add(taskMenu);
        reservationPrice = new JMenuItem("price of a reservation");
        reservationPrice.addActionListener(new jobTaskReservationPriceListener());
        taskMenu.add(reservationPrice);

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

    private class UpdateListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            container.removeAll();
            container.add(new UpdatePanel(), BorderLayout.CENTER);
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
    private class researchHotelCustomersListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            container.removeAll();
            container.add(new HotelCustomersPanel(), BorderLayout.CENTER);
            container.repaint();
            ProgramWindow.this.setVisible(true);
        }
    }
    private class researchCustomerReservationsListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            container.removeAll();
            container.add(new CustomerHotelsPanel(), BorderLayout.CENTER);
            container.repaint();
            ProgramWindow.this.setVisible(true);
        }
    }
    private class jobTaskReservationPriceListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            container.removeAll();
            container.add(new JobTaskPricePanel(), BorderLayout.CENTER);
            container.repaint();
            ProgramWindow.this.setVisible(true);
        }
    }
}
