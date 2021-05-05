package view;

import model.Hotel;
import model.Room;
import model.RoomType;

import javax.swing.*;
import java.awt.*;
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
    private ArrayList<String> mails;

    public FormPanel(){
        this.setLayout(new GridLayout());
        customerMailLabel = new JLabel("Usermail");

        //*
        mails = new ArrayList<>();
        try{

            this.add(customerMailLabel);
            // get Mails
            mail = new JComboBox(mails.toArray());
            this.add(mail);
        }
        catch (Exception exception){JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        //*//*
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
        SpinnerDateModel spinMod = new SpinnerDateModel();
        beginDate = new JSpinner(spinMod);
        beginDate.setEditor(new JSpinner.DateEditor(beginDate,"dd.MM.yyyy"));
        this.add(beginDate);

        endingDateLabel = new JLabel("Beginning date");
        this.add(endingDateLabel);
        endDate = new JSpinner(spinMod);
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


    }
}