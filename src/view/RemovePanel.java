package view;

import controller.ApplicationController;
import exception.DeleteReservationException;
import exception.GetReservationException;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemovePanel extends JPanel{
    private JLabel listReservation;
    private JComboBox reservations;
    private JButton validationButton;
    private ArrayList<String> reservationsString;
    private ArrayList<Reservation> arrayReservations;

    private ApplicationController applicationController;

    public RemovePanel() {
        this.setLayout(new GridLayout(13,2,5,5));

        applicationController = new ApplicationController();
        reservationsString = new ArrayList<>();
        arrayReservations = new ArrayList<>();
        try {
            arrayReservations = applicationController.getReservations();
            reservationsString = applicationController.stringReservation(arrayReservations);
            listReservation = new JLabel("List of reservations");
            reservations = new JComboBox(reservationsString.toArray());
            reservations.setSelectedItem(0);
            reservations.setMaximumRowCount(15);
            this.add(reservations);
        }
        catch (GetReservationException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        validationButton = new JButton("Validation");
        this.add(validationButton);
        RemovePanel.ButtonListener listener = new RemovePanel.ButtonListener();
        validationButton.addActionListener(listener);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Reservation reservation = applicationController.researchReservation(reservations.getSelectedItem().toString(), arrayReservations);
            try {
                applicationController.deleteReservation(reservation);
            }
            catch (DeleteReservationException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }
}
