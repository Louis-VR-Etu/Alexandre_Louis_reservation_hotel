package view;

import controller.ApplicationController;
import exception.GetReservationException;
import exception.JobTaskReservationPriceException;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JobTaskPricePanel extends JPanel {
    private ApplicationController applicationController;

    private ArrayList<Reservation> reservationsArray;
    private ArrayList<String> reservationString;
    JLabel reservationLabel, priceLabel;
    private JComboBox reservations;
    private JButton validationButton;


    public JobTaskPricePanel(){
        this.setLayout(new GridLayout(3,1,5,5));

        applicationController = new ApplicationController();

        reservationsArray = new ArrayList<>();
        reservationString = new ArrayList<>();
        try{
            reservationsArray = applicationController.getReservations();
            reservationString = applicationController.stringReservation(reservationsArray);
            reservationLabel = new JLabel("reservation");
            this.add(reservationLabel);
            reservations = new JComboBox(reservationString.toArray());
            reservations.setSelectedItem(0);
            reservations.setMaximumRowCount(10);
            this.add(reservations);

        }
        catch(GetReservationException exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        validationButton = new JButton("Validation");
        this.add(validationButton);
        JobTaskPricePanel.ButtonListener listenerStation = new JobTaskPricePanel.ButtonListener();
        validationButton.addActionListener(listenerStation);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JobTaskPricePanel.this.setLayout(new GridLayout(1,1,15,15));
            Reservation reservation = applicationController.researchReservation(reservations.getSelectedItem().toString(), reservationsArray);
            try {
                //*
                //TODO
                String price = applicationController.jobTaskReservationPrice(reservation);

                priceLabel = new JLabel(price);
                JobTaskPricePanel.this.removeAll();
                JobTaskPricePanel.this.add(priceLabel);
                JobTaskPricePanel.this.revalidate();
                JobTaskPricePanel.this.repaint();
            }
            catch (JobTaskReservationPriceException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            //     */
        }
    }
}
