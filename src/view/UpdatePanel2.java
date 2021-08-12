package view;

import controller.ApplicationController;
import exception.GetFreeRoomsException;
import model.RoomAndBed;
import model.Reservation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class UpdatePanel2 extends JPanel{
    private Reservation reservation;
    private ArrayList<RoomAndBed> rooms;
    private ApplicationController applicationController;
    private JSpinner spinnerPeopleAmount;
    private JSpinner spinnerDateDeb;
    private JSpinner spinnerDateFin;
    private SpinnerNumberModel spinnerPeopleAmountModel;
    private SpinnerDateModel spinnerDateModelDeb;
    private SpinnerDateModel spinnerDateModelFin;
    private JLabel dateLabel,endingDateLabel, peopleAmountLabel;
    private JButton validationButton;

    public UpdatePanel2(Reservation reservation){
        this.setLayout(new GridLayout(0,2,5,5));
        applicationController = new ApplicationController();

        this.reservation = reservation;

        dateLabel = new JLabel("Beginning date :");
        this.add(dateLabel);
        Date beginningDate = reservation.getBeginningDate().getTime();
        spinnerDateModelDeb = new SpinnerDateModel(beginningDate,null,null,Calendar.DAY_OF_MONTH);
        spinnerDateDeb = new JSpinner(spinnerDateModelDeb);
        spinnerDateDeb.setEditor(new JSpinner.DateEditor(spinnerDateDeb, "dd-MM-yyyy"));
        this.add(spinnerDateDeb);

        endingDateLabel = new JLabel("Ending date :");
        this.add(endingDateLabel);
        Date endingDate = reservation.getEndingDate().getTime();
        spinnerDateModelFin = new SpinnerDateModel(endingDate,null,null,Calendar.DAY_OF_MONTH);
        spinnerDateFin = new JSpinner(spinnerDateModelFin);
        spinnerDateFin.setEditor(new JSpinner.DateEditor(spinnerDateFin, "dd-MM-yyyy"));
        this.add(spinnerDateFin);

        peopleAmountLabel = new JLabel("amount of people");
        this.add(peopleAmountLabel);
        int people = reservation.getPeople();
        spinnerPeopleAmountModel = new SpinnerNumberModel(people,1,20,1);
        spinnerPeopleAmount = new JSpinner(spinnerPeopleAmountModel);
        this.add(spinnerPeopleAmount);

        validationButton = new JButton("Validation");
        this.add(validationButton);
        UpdatePanel2.AddButtonListener listener = new UpdatePanel2.AddButtonListener();
        validationButton.addActionListener(listener);
    }

    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String hotelSelected = reservation.getHotelName();
            Date beginDate = spinnerDateModelDeb.getDate();
            Date endDate = spinnerDateModelFin.getDate();
            int peopleAmount = spinnerPeopleAmountModel.getNumber().intValue();
            try {
                if(applicationController.verifyDates(beginDate,endDate)) {
                    rooms = applicationController.getFreeRooms(hotelSelected, beginDate, endDate, peopleAmount);
                    UpdatePanel2.this.removeAll();
                    UpdatePanel2.this.setLayout(new GridLayout(0, 1, 5, 5));
                    UpdatePanel2.this.add(new UpdatePanel3(reservation, rooms, beginDate, endDate, peopleAmount), BorderLayout.CENTER);
                    UpdatePanel2.this.revalidate();
                    UpdatePanel2.this.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(null, "beginning date must be before ending date", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            catch (GetFreeRoomsException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }
}
