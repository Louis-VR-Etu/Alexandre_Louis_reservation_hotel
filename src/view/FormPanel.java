package view;

import model.Hotel;
import model.Room;
import model.RoomType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FormPanel extends JPanel {


    private JLabel  customerMailLabel, roomNumberLabel, hotelNameLabel, beginningDateLabel, endingDateLabel, allInLabel, peopleAmountLabel, roomTypeLabel, remarksLabel, contactsLabel,couponCodeLabel;
    private JTextField  remarks;
    private JCheckBox buttonAllIn;
    private ButtonGroup buttonGroup;
    private JComboBox hotel, roomType, Room, mail;
    private JButton validationButton;
    private JSpinner beginDate, endDate;
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



    }
}
