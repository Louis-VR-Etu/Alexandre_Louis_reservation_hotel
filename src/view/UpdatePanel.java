package view;

import controller.ApplicationController;
import exception.*;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class UpdatePanel extends JPanel{

    private JLabel listReservation;
    private ArrayList<String> reservationsString;
    private JButton validationButton;
    private JComboBox reservations;
    private ArrayList<Reservation> arrayReservations;

    private ApplicationController applicationController;

    public UpdatePanel() {
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
        UpdatePanel.ButtonListener listener = new UpdatePanel.ButtonListener();
        validationButton.addActionListener(listener);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //TODO appeler une 2eme fenetre
            /*
            Reservation reservation = applicationController.researchReservation(reservations.getSelectedItem().toString(), arrayReservations);
            try {
                applicationController.deleteReservation(reservation);
                JLabel priceLabel = new JLabel("reservation has been removed");
                UpdatePanel.this.removeAll();
                UpdatePanel.this.add(priceLabel);
                UpdatePanel.this.revalidate();
                UpdatePanel.this.repaint();
            }

            catch (DeleteReservationException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            */
        }
    }
}
