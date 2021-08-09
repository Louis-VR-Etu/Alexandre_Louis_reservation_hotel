package view;

import controller.ApplicationController;
import exception.CustomerAccessException;
import exception.AddReservationException;
import model.Hotel;
import model.Room;
import model.RoomType;
import model.Customer;
import model.Reservation;

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
    private JSpinner beginDate, endDate, peoples;
    private ArrayList<Hotel> hotels;
    private ArrayList<RoomType> roomTypes;
    private ArrayList<Room> freeRooms;
    private ArrayList<Customer> customers;
    private SpinnerDateModel spinnerDateModel;

    private ApplicationController applicationController;

    public FormPanel() {
        this.setLayout(new GridLayout(16, 2, 5, 5));

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
        //*/

        beginningDateLabel = new JLabel("Beginning date");
        this.add(beginningDateLabel);
        SpinnerDateModel spinMod1 = new SpinnerDateModel();
        beginDate = new JSpinner(spinMod1);
        beginDate.setEditor(new JSpinner.DateEditor(beginDate, "dd.MM.yyyy"));
        this.add(beginDate);

        endingDateLabel = new JLabel("Ending date");
        this.add(endingDateLabel);
        SpinnerDateModel spinMod2 = new SpinnerDateModel();

        endDate = new JSpinner(spinMod2);
        endDate.setEditor(new JSpinner.DateEditor(endDate, "dd.MM.yyyy"));
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
        */

        //*/
        validationButton = new JButton("Validation");
        this.add(validationButton);
        ButtonListener listener = new ButtonListener();
        validationButton.addActionListener(listener);

    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                Date beginningDate = spinnerDateModel.getDate();
                GregorianCalendar beginningDates = (GregorianCalendar) GregorianCalendar.getInstance();
                beginningDates.setGregorianChange(beginningDate);
                Room roomSelected = applicationController.researchRoom(room.getSelectedItem().toString(), freeRooms);
                Hotel hotelSelected = applicationController.researchHotel(hotel.getSelectedItem().toString(), hotels);
                Date endingDate = spinnerDateModel.getDate();
                GregorianCalendar endingDates = (GregorianCalendar) GregorianCalendar.getInstance();
                endingDates.setGregorianChange(endingDate);
                Boolean allInclusive = buttonAllIn.isSelected() ? false : true;
                Integer peopleTemp = applicationController.verifyPeople(people.getText());
                String remark = applicationController.verifyTitle(remarks.getText());
                String additionalContact = applicationController.verifyAdditionalContact(contacts.getText());
                String couponCode = applicationController.verifyCouponCode(coupon.getText());
                Customer customerSelected = applicationController.researchCustomer(customer.getSelectedItem().toString(), customers);

                Reservation reservation = new Reservation(beginningDates, roomSelected.getNumber(), hotelSelected.getName(), endingDates, allInclusive, peopleTemp, remark, additionalContact, couponCode, customerSelected.getMail());
                try {
                    applicationController.addReservation(reservation);
                } catch (AddReservationException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }catch (AddReservationException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }
}
