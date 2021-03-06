package view;

import controller.ApplicationController;
import exception.GetFreeRoomsException;
import exception.GetHotelsException;
import model.Hotel;
import model.RoomAndBed;
import model.FreeRoomsModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class FreeRoomsPanel extends JPanel{
    private FreeRoomsModel freeRoomsModel;
    private ArrayList<RoomAndBed> rooms;
    private ApplicationController applicationController;
    private JSpinner spinnerPeopleAmount;
    private JSpinner spinnerDateDeb;
    private JSpinner spinnerDateFin;
    private SpinnerNumberModel spinnerPeopleAmountModel;
    private SpinnerDateModel spinnerDateModelDeb;
    private SpinnerDateModel spinnerDateModelFin;
    private ArrayList<Hotel> arrayHotels;
    private ArrayList<String> hotelStrings;
    private JLabel listHotels, dateLabel,endingDateLabel, peopleAmountLabel;
    private JComboBox hotels;
    private JButton validationButton;

    public FreeRoomsPanel(boolean add){
        this.setLayout(new GridLayout(0,2,5,5));
        applicationController = new ApplicationController();
        try {
            arrayHotels = applicationController.getHotels();
            hotelStrings = applicationController.stringHotelNames(arrayHotels);
            listHotels = new JLabel("List of hotels");
            hotels = new JComboBox(hotelStrings.toArray());
            hotels.setSelectedItem(0);
            hotels.setMaximumRowCount(15);
            this.add(listHotels);
            this.add(hotels);
        }
        catch (GetHotelsException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        dateLabel = new JLabel("Beginning date :");
        this.add(dateLabel);
        spinnerDateModelDeb = new SpinnerDateModel();
        spinnerDateDeb = new JSpinner(spinnerDateModelDeb);
        spinnerDateDeb.setEditor(new JSpinner.DateEditor(spinnerDateDeb, "dd-MM-yyyy"));
        this.add(spinnerDateDeb);

        endingDateLabel = new JLabel("Ending date :");
        this.add(endingDateLabel);
        spinnerDateModelFin = new SpinnerDateModel();
        spinnerDateFin = new JSpinner(spinnerDateModelFin);
        spinnerDateFin.setEditor(new JSpinner.DateEditor(spinnerDateFin, "dd-MM-yyyy"));
        this.add(spinnerDateFin);

        peopleAmountLabel = new JLabel("amount of people");
        this.add(peopleAmountLabel);
        spinnerPeopleAmountModel = new SpinnerNumberModel(1,1,20,1);
        spinnerPeopleAmount = new JSpinner(spinnerPeopleAmountModel);
        this.add(spinnerPeopleAmount);

        validationButton = new JButton("Validation");
        this.add(validationButton);
        if(add){
            FreeRoomsPanel.AddButtonListener listener = new FreeRoomsPanel.AddButtonListener();
            validationButton.addActionListener(listener);
        }
        else {
            ListButtonListener listener = new ListButtonListener();
            validationButton.addActionListener(listener);
        }
    }

    private class ListButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String hotelSelected = hotels.getSelectedItem().toString();
            Date beginDate = spinnerDateModelDeb.getDate();
            Date endDate = spinnerDateModelFin.getDate();
            int peopleAmount = spinnerPeopleAmountModel.getNumber().intValue();
            try {
if(applicationController.verifyDates(beginDate,endDate)) {
    rooms = applicationController.getFreeRooms(hotelSelected, beginDate, endDate, peopleAmount); //TODO
    FreeRoomsPanel.this.removeAll();
    FreeRoomsPanel.this.setLayout(new GridLayout(0, 1, 5, 5));
    freeRoomsModel = new FreeRoomsModel(rooms);
    JTable freeRooms = new JTable(freeRoomsModel);
    JScrollPane scrollPane = new JScrollPane(freeRooms);
    FreeRoomsPanel.this.add(scrollPane);
    FreeRoomsPanel.this.revalidate();
    FreeRoomsPanel.this.repaint();
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

    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String hotelSelected = hotels.getSelectedItem().toString();
            Date beginDate = spinnerDateModelDeb.getDate();
            Date endDate = spinnerDateModelFin.getDate();
            int peopleAmount = spinnerPeopleAmountModel.getNumber().intValue();
            try {
                if(applicationController.verifyDates(beginDate,endDate)) {
                    rooms = applicationController.getFreeRooms(hotelSelected, beginDate, endDate, peopleAmount);
                    FreeRoomsPanel.this.removeAll();
                    FreeRoomsPanel.this.add(new FormPanel(rooms, beginDate, endDate, peopleAmount), BorderLayout.CENTER);
                    FreeRoomsPanel.this.revalidate();
                    FreeRoomsPanel.this.repaint();
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
