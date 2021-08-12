package view;

import controller.ApplicationController;
import exception.AddReservationException;
import exception.CustomerAccessException;
import exception.UpdateReservationException;
import model.Customer;
import model.Reservation;
import model.RoomAndBed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class UpdatePanel3 extends JPanel {
    private JLabel conserveRoomLabel, allInLabel, roomTypeLabel, remarksLabel, contactsLabel, couponCodeLabel;
    private JTextField remarks, contacts, coupon;
    private JCheckBox buttonAllIn, buttonConserve;
    private JComboBox roomType, mail;
    private JButton validationButton;
    private ArrayList<RoomAndBed> freeRooms;
    private ArrayList<Customer> customers;
    private ApplicationController applicationController;
    private Date beginDate, endDate;
    private int peopleAmount;
    private Reservation reservation;

    public UpdatePanel3(Reservation reservation,ArrayList<RoomAndBed> rooms, Date beginningDate, Date endingDate, int peopleAmount) {
        this.reservation = reservation;
        this.beginDate = beginningDate;
        this.endDate = endingDate;
        this.peopleAmount = peopleAmount;
        applicationController = new ApplicationController();
        this.setLayout(new GridLayout(0, 2, 5, 5));

        freeRooms = rooms;
        ArrayList<String> roomTypes;
        roomTypes = applicationController.stringFreeRoomType(freeRooms);
        roomTypeLabel = new JLabel("Rooms");
        this.add(roomTypeLabel);
        roomType = new JComboBox(roomTypes.toArray());
        roomType.setSelectedItem(0);
        roomType.setMaximumRowCount(10);
        this.add(roomType);
        if(reservation.getPeople() == peopleAmount){
            conserveRoomLabel = new JLabel("Conserve the former room?");
            this.add(conserveRoomLabel);
            buttonConserve = new JCheckBox("Conserve the former room");
            this.add(buttonConserve);

        }


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
        UpdatePanel3.ButtonListener listener = new UpdatePanel3.ButtonListener();
        validationButton.addActionListener(listener);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                GregorianCalendar beginningDates = new GregorianCalendar();
                beginningDates.setTime(beginDate);
                int roomNumberSelected;
                String roomHotelSelected;
                if(buttonConserve.isSelected()){
                    roomHotelSelected = UpdatePanel3.this.reservation.getHotelName();
                    roomNumberSelected = UpdatePanel3.this.reservation.getRoomNumber();
                }else{
                    RoomAndBed roomSelected = applicationController.researchFreeRoom(roomType.getSelectedItem().toString(), freeRooms);
                roomNumberSelected=roomSelected.getNumber();
                roomHotelSelected = roomSelected.getHotelName();
                }
                GregorianCalendar endingDates = new GregorianCalendar();
                endingDates.setTime(endDate);
                Boolean allInclusive = buttonAllIn.isSelected();

                String remark = applicationController.getReservationManager().verifyString(remarks.getText());
                String additionalContact = contacts.getText();
                String couponCode = coupon.getText();
                String customerSelected = reservation.getCustomerMail();
                Reservation reservationUpdated = new Reservation(beginningDates, roomNumberSelected, roomHotelSelected, endingDates, allInclusive, peopleAmount, remark, additionalContact, couponCode, customerSelected);

                applicationController.updateReservation(reservation,reservationUpdated);
                JLabel priceLabel = new JLabel("reservation has been Updated");
                UpdatePanel3.this.removeAll();
                UpdatePanel3.this.add(priceLabel);
                UpdatePanel3.this.revalidate();
                UpdatePanel3.this.repaint();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
