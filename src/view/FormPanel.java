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
    private JLabel customerMailLabel, allInLabel, roomTypeLabel, remarksLabel, contactsLabel, couponCodeLabel;
    private JTextField remarks, contacts, coupon;
    private JCheckBox buttonAllIn;
    private JComboBox roomType, mail;
    private JButton validationButton;
    private ArrayList<RoomAndBed> freeRooms;
    private ArrayList<Customer> customers;
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

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try{
                GregorianCalendar beginningDates = new GregorianCalendar();
                beginningDates.setTime(beginDate);
                RoomAndBed roomSelected = applicationController.researchFreeRoom(roomType.getSelectedItem().toString(), freeRooms);

                GregorianCalendar endingDates = new GregorianCalendar();
                endingDates.setTime(endDate);
                Boolean allInclusive = buttonAllIn.isSelected();

                String remark = applicationController.verifyTitle(remarks.getText());
                String additionalContact = contacts.getText();
                String couponCode = coupon.getText();
                String customerSelected = mail.getSelectedItem().toString();
                Reservation reservation = new Reservation(beginningDates, roomSelected.getNumber(), roomSelected.getHotelName(), endingDates, allInclusive, peopleAmount, remark, additionalContact, couponCode, customerSelected);

                applicationController.addReservation(reservation);
                JLabel priceLabel = new JLabel("reservation has been added");
                FormPanel.this.removeAll();
                FormPanel.this.add(priceLabel);
                FormPanel.this.revalidate();
                FormPanel.this.repaint();
            } catch (AddReservationException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
