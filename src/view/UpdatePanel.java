package view;

import controller.ApplicationController;
import exception.AddReservationException;
import exception.CustomerAccessException;
import exception.GetReservationException;
import exception.UpdateReservationException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class UpdatePanel extends JPanel{
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
    private SpinnerDateModel spinnerDateModelBegin, spinnerDateModelEnd;
    private SpinnerNumberModel spinnerPeopleAmountModel;
    private JComboBox reservations;
    private ArrayList<Reservation> arrayReservations;

    private ApplicationController applicationController;

    public UpdatePanel() {
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
        spinnerPeopleAmountModel = new SpinnerNumberModel(1, 1, 20, 1);
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
        */

        //*/
        validationButton = new JButton("Validation");
        this.add(validationButton);
        UpdatePanel.ButtonListener listener = new UpdatePanel.ButtonListener();
        validationButton.addActionListener(listener);
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Reservation reservation = applicationController.researchReservation(reservations.getSelectedItem().toString(), arrayReservations);
            try {
                /*//TODO a modifier
                GregorianCalendar beginningDate;
                if (beginDate.toString().compareTo("DD/MM/YYYY") == 0) {
                    beginningDate = reservation.getBeginningDate();
                } else {
                    String day = beginDate.getText().charAt(0) + "" + beginDate.getText().charAt(1);
                    String month = beginDate.getText().charAt(3) + "" + beginDate.getText().charAt(4);
                    String year = beginDate.getText().charAt(6) + "" + beginDate.getText().charAt(7) + beginDate.getText().charAt(8) + "" + beginDate.getText().charAt(9);
                    Date date = applicationController.verifyBeginningDate(day, month, year);

                    beginningDate = new GregorianCalendar(date.getYear(), date.getMonth(), date.getDay());
                }
*/
                Room roomSelected = applicationController.researchRoom(room.getSelectedItem().toString(), freeRooms);

                Hotel hotelSelected = applicationController.researchHotel(hotel.getSelectedItem().toString(), hotels);

                /*//TODO a modifier
                GregorianCalendar endingDate;
                if (endDate.toString().compareTo("DD/MM/YYYY") == 0) {
                    endingDate = reservation.getEndingDate();
                } else {
                    String day = endDate.getText().charAt(0) + "" + endDate.getText().charAt(1);
                    String month = endDate.getText().charAt(3) + "" + endDate.getText().charAt(4);
                    String year = endDate.getText().charAt(6) + "" + endDate.getText().charAt(7) + endDate.getText().charAt(8) + "" + endDate.getText().charAt(9);
                    Date date = applicationController.verifyEndingDate(day, month, year);

                    endingDate = new GregorianCalendar(date.getYear(), date.getMonth(), date.getDay());
                }
*/

                Boolean allInclusive = buttonAllIn.isSelected() ? false : true;

                Integer peopleTemp;
                if (people.getText().compareTo("") != 0) {
                    peopleTemp = applicationController.verifyPeople(people.getText());
                } else {
                    peopleTemp = reservation.getPeople();
                }

                String remark;
                if (remarks.getText().compareTo("") != 0) {
                    remark = applicationController.verifyTitle(remarks.getText());
                } else {
                    remark = reservation.getTitle();
                }

                String additionalContact;
                if (contacts.getText().compareTo("") != 0) {
                    additionalContact = applicationController.verifyAdditionalContact(contacts.getText());
                } else {
                    additionalContact = reservation.getAdditionalContact();
                }

                String couponCode;
                if (coupon.getText().compareTo("") != 0) {
                    couponCode = applicationController.verifyCouponCode(coupon.getText());
                } else {
                    couponCode = reservation.getCouponCode();
                }

                Customer customerSelected = applicationController.researchCustomer(customer.getSelectedItem().toString(), customers);

                Reservation reservationUpdated = new Reservation(beginningDate, roomSelected.getNumber(), hotelSelected.getName(), endingDates, allInclusive, peopleTemp, remark, additionalContact, couponCode, customerSelected.getMail());

                try {
                    applicationController.updateReservation(reservation, reservationUpdated);
                } catch (UpdateReservationException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
            catch (AddReservationException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }
}
