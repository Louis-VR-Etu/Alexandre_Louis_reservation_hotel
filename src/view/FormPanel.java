package view;

import controller.ApplicationController;
import exception.CustomerAccessException;
import model.Hotel;
import model.Room;
import model.RoomType;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPanel extends JPanel {
    private JLabel  customerMailLabel, roomNumberLabel, hotelNameLabel, beginningDateLabel, endingDateLabel, allInLabel, peopleAmountLabel, roomTypeLabel, remarksLabel, contactsLabel,couponCodeLabel;
    private JTextField  remarks,contacts, coupon;
    private JCheckBox buttonAllIn;
    private ButtonGroup buttonGroup;
    private JComboBox hotel, roomType, room, mail;
    private JButton validationButton;
    private JSpinner beginDate, endDate,peoples;
    private ArrayList<Hotel> hotels;
    private ArrayList<RoomType> roomTypes;
    private ArrayList<Room> freeRooms;
    private ArrayList<Customer> customers;

    private ApplicationController applicationController;

    public FormPanel(){
        this.setLayout(new GridLayout(13,2,5,5));
        customerMailLabel = new JLabel("Usermail");

        customers = new ArrayList<>();
        applicationController = new ApplicationController();
        ArrayList<String> mails;
        try{
            customers = applicationController.getCustomers();
            mails = applicationController.stringCustomer(customers);
            customerMailLabel = new JLabel("mails");
            this.add(customerMailLabel);
            mail = new JComboBox(mails.toArray());
            this.add(mail);
        }
        catch (CustomerAccessException exception){
            throw exception;
        }
 /*
        try {
            hotelNameLabel = new JLabel("Hotel");
            this.add(hotelNameLabel);
            //get hotels
            ArrayList<String> hotelNames;
            //get hotelNames
            // hotel = new JComboBox(hotelNames.toArray());
        }

        catch (Exception exception){JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        //*/
        beginningDateLabel = new JLabel("Beginning date");
        this.add(beginningDateLabel);
        SpinnerDateModel spinMod1 = new SpinnerDateModel();
        beginDate = new JSpinner(spinMod1);
        beginDate.setEditor(new JSpinner.DateEditor(beginDate,"dd.MM.yyyy"));
        this.add(beginDate);

        endingDateLabel = new JLabel("Ending date");
        this.add(endingDateLabel);
        SpinnerDateModel spinMod2 = new SpinnerDateModel();

        endDate = new JSpinner(spinMod2);
        endDate.setEditor(new JSpinner.DateEditor(endDate,"dd.MM.yyyy"));
        this.add(endDate);

        peopleAmountLabel = new JLabel("amount of people");
        this.add(peopleAmountLabel);
        peoples = new JSpinner();
        this.add(peoples);

        allInLabel = new JLabel("All inclusive?");
        this.add(allInLabel);
        buttonAllIn = new JCheckBox("All inclusive");
        this.add(buttonAllIn);

        remarksLabel = new JLabel("Remarks");
        this.add(remarksLabel);
        remarks = new JTextField();
        this.add(remarks);

        contactsLabel = new JLabel("additional contacts");
        this.add(contactsLabel);
        contacts = new JTextField();
        this.add(contacts);

        couponCodeLabel = new JLabel("coupon code?");
        this.add(couponCodeLabel);
        coupon = new JTextField();
        this.add(coupon);

        roomTypeLabel = new JLabel("room type");
        this.add(roomTypeLabel);
        /*
        try{

            // get Room types
            roomType = new JComboBox(roomTypes.toArray());
            this.add(roomType);
        }
        catch (Exception exception){JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        roomNumberLabel = new JLabel("room number");
        this.add(roomNumberLabel);
        try{

            // get free Rooms
            room = new JComboBox(freeRooms.toArray());
            this.add(room);
        }
        catch (Exception exception){JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        //*/
        validationButton = new JButton("Validation");
        this.add(validationButton);
        //  ButtonListener listener = new ButtonListener();
        //   validationButton.addActionListener(listener);

    }
    //*
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){

        }

    }
//*/

}
