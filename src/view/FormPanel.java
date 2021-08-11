package view;

import controller.ApplicationController;
import exception.CustomerAccessException;
import exception.AddReservationException;
import exception.GetFreeRoomsException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormPanel extends JPanel {

    private JLabel customerMailLabel, roomNumberLabel, hotelNameLabel, beginningDateLabel, endingDateLabel, allInLabel, peopleAmountLabel, roomTypeLabel, remarksLabel, contactsLabel, couponCodeLabel;
    private JTextField people, remarks, contacts, coupon;
    private JCheckBox buttonAllIn;
    private ButtonGroup buttonGroup;
    private JComboBox hotel, roomType, room, customer, mail, hotelName, roomTypeName;
    private JButton validationButton;
    // private JSpinner beginDate, endDate, peoples;
    private ArrayList<RoomAndBed> freeRooms;
    private ArrayList<Hotel> hotels;
    private ArrayList<RoomType> roomTypes;
    //private ArrayList<Room> freeRooms;
    private ArrayList<Customer> customers;
    private SpinnerDateModel spinnerDateModelBegin, spinnerDateModelEnd;
    private SpinnerNumberModel spinnerPeopleAmountModel;
    private ApplicationController applicationController;
    private Date beginDate, endDate;
    private int peopleAmount;


    public FormPanel(ArrayList<RoomAndBed> rooms, Date beginningDate, Date endingDate, int peopleAmount) {
        this.beginDate =beginningDate;
        this.endDate = endingDate;
        this.peopleAmount = peopleAmount;
        this.setLayout(new GridLayout(0, 2, 5, 5));

        customers = new ArrayList<>();
        applicationController = new ApplicationController();
        ArrayList<String> mails;
        try {
            customers = applicationController.getCustomers();
            mails = applicationController.stringCustomerMail(customers);
            customerMailLabel = new JLabel("mails");
            this.add(customerMailLabel);
            mail = new JComboBox(mails.toArray());
            mail.setSelectedItem(0);
            mail.setMaximumRowCount(5);
            this.add(mail);
        } catch (CustomerAccessException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        freeRooms = rooms;
        ArrayList<String> roomTypes;
        roomTypes = applicationController.stringFreeRoomType(freeRooms);
        roomTypeLabel = new JLabel("Rooms");
        this.add(roomTypeLabel);
        roomType = new JComboBox(roomTypes.toArray());
        roomType.setSelectedItem(0);
        roomType.setMaximumRowCount(10);
        this.add(roomType);



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


        validationButton = new JButton("Validation");
        this.add(validationButton);
        ButtonListener listener = new ButtonListener();
        validationButton.addActionListener(listener);



    }


    /*
    public FormPanel() {
        this.setLayout(new GridLayout(0, 2, 5, 5));




        customers = new ArrayList<>();
        applicationController = new ApplicationController();
        ArrayList<String> mails;
        try {
            customers = applicationController.getCustomers();
            mails = applicationController.stringCustomerMail(customers);
            customerMailLabel = new JLabel("mails");
            this.add(customerMailLabel);
            mail = new JComboBox(mails.toArray());
            mail.setSelectedItem(0);
            mail.setMaximumRowCount(5);
            this.add(mail);
        } catch (CustomerAccessException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        hotels = new ArrayList<>();
        applicationController = new ApplicationController();
        ArrayList<String> hotelNames;

        try {
            hotels = applicationController.getHotels();
            hotelNames = applicationController.stringHotelNames(hotels);
            hotelNameLabel = new JLabel("hotel names");
            this.add(hotelNameLabel);
            hotelName = new JComboBox(hotelNames.toArray());
            hotelName.setSelectedItem(0);
            hotelName.setMaximumRowCount(5);
            this.add(hotelName);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }


        beginningDateLabel = new JLabel("Beginning date");
        this.add(beginningDateLabel);
        spinnerDateModelBegin = new SpinnerDateModel();
        beginDate = new JSpinner(spinnerDateModelBegin);
        beginDate.setEditor(new JSpinner.DateEditor(beginDate, "dd.MM.yyyy"));
        this.add(beginDate);

        endingDateLabel = new JLabel("Ending date");
        this.add(endingDateLabel);
        spinnerDateModelEnd = new SpinnerDateModel();

        endDate = new JSpinner(spinnerDateModelEnd);
        endDate.setEditor(new JSpinner.DateEditor(endDate, "dd.MM.yyyy"));
        this.add(endDate);


        peopleAmountLabel = new JLabel("amount of people");
        this.add(peopleAmountLabel);
        spinnerPeopleAmountModel = new SpinnerNumberModel(1,1,20,1);
        peoples = new JSpinner(spinnerPeopleAmountModel);
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

        roomTypes = new ArrayList<>();
        applicationController = new ApplicationController();
        ArrayList<String> roomTypeNames;

        try {
            roomTypes = applicationController.getRoomTypes();
            roomTypeNames = applicationController.stringRoomTypeNames(roomTypes);
            roomTypeLabel = new JLabel("room type names");
            this.add(roomTypeLabel);
            roomTypeName = new JComboBox(roomTypeNames.toArray());
            roomTypeName.setSelectedItem(0);
            roomTypeName.setMaximumRowCount(5);
            this.add(roomTypeName);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        /*
        roomNumberLabel = new JLabel("room number");
        this.add(roomNumberLabel);
        try{

            // get free Rooms
            room = new JComboBox(freeRooms.toArray());
            this.add(room);
        }
        catch (Exception exception){JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }



        validationButton = new JButton("Validation");
        this.add(validationButton);
        ButtonListener listener = new ButtonListener();
        validationButton.addActionListener(listener);

    }

     */
   /*
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {


               Room roomSelected = applicationController.researchRoom(room.getSelectedItem().toString(), freeRooms);
                Hotel hotelSelected = applicationController.researchHotel(hotel.getSelectedItem().toString(), hotels);
                Date endingDate = spinnerDateModelEnd.getDate();
                GregorianCalendar endingDates = new GregorianCalendar();
                endingDates.setTime(endingDate);
                Boolean allInclusive = buttonAllIn.isSelected();
                Integer peopleTemp = spinnerPeopleAmountModel.getNumber().intValue(); //todo verify?
                String remark = applicationController.verifyTitle(remarks.getText());
                String additionalContact = applicationController.verifyAdditionalContact(contacts.getText());
                String couponCode = applicationController.verifyCouponCode(coupon.getText());
                Customer customerSelected = applicationController.researchCustomer(customer.getSelectedItem().toString(), customers);
                Reservation reservation = new Reservation(beginningDate, roomSelected.getNumber(), hotelSelected.getName(), endingDates, allInclusive, peopleTemp, remark, additionalContact, couponCode, customerSelected.getMail());


                try {

                } /catch (AddReservationException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                validationButton = new JButton("Validation");
                FormPanel.this.add(validationButton);
                ButtonListener2 listener = new ButtonListener2();
                validationButton.addActionListener(listener);

            }catch (GetFreeRoomsException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

     //*/

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try{
                GregorianCalendar beginningDates = new GregorianCalendar();
                beginningDates.setTime(beginDate);
                RoomAndBed roomSelected = applicationController.researchFreeRoom(roomType.getSelectedItem().toString(), freeRooms);

                GregorianCalendar endingDates = new GregorianCalendar();
                endingDates.setGregorianChange(endDate);
                Boolean allInclusive = buttonAllIn.isSelected();

                String remark = applicationController.verifyTitle(remarks.getText());
                String additionalContact = contacts.getText();//TODO verify si null? applicationController.verifyAdditionalContact(contacts.getText());
                String couponCode = coupon.getText(); // TODO verify si null? applicationController.verifyCouponCode(coupon.getText());
                Customer customerSelected = applicationController.researchCustomer(mail.getSelectedItem().toString(), customers);
                Reservation reservation = new Reservation(beginningDates, roomSelected.getNumber(), roomSelected.getHotelName(), endingDates, allInclusive, peopleAmount, remark, additionalContact, couponCode, customerSelected.getMail());

                applicationController.addReservation(reservation);
                JLabel priceLabel = new JLabel("reservation has been removed");
                FormPanel.this.removeAll();
                FormPanel.this.add(priceLabel);
                FormPanel.this.revalidate();
                FormPanel.this.repaint();
            } catch (AddReservationException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

        }
    }
}
