package view;

import controller.ApplicationController;
import exception.GetReservationException;
import model.AllReservationsModel;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AllReservationsPanel extends JPanel{
    private AllReservationsModel allReservationsModel;
    private ArrayList<Reservation> reservations;

    private ApplicationController applicationController;

    public AllReservationsPanel(){ //TODO afficher les réservations
        this.setLayout(new GridLayout(16, 16, 5, 5));
        applicationController = new ApplicationController();
        try{
            System.out.println("all reservation panel");
            reservations = applicationController.getReservations();
            allReservationsModel = new AllReservationsModel(reservations);
            JTable table = new JTable(allReservationsModel);
            JScrollPane scrollPane = new JScrollPane(table);
            this.add(scrollPane);
        }
        catch(GetReservationException exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
