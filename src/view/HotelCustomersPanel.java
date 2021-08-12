package view;

import controller.ApplicationController;
import exception.GetHotelCustomersException;
import exception.GetHotelsException;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HotelCustomersPanel extends JPanel  {
    private HotelCustomersModel hotelCustomersModel;
    private ArrayList<CustomerRoom> customers;
    private ApplicationController applicationController;
    private ArrayList<Hotel> arrayHotels;
    private ArrayList<String> hotelStrings;
    private JLabel listHotels;
    private JComboBox hotels;
    private JButton validationButton;

    public HotelCustomersPanel() {
        this.setLayout(new GridLayout(0, 2, 5, 5));
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
        } catch (GetHotelsException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        validationButton = new JButton("Validation");
        this.add(validationButton);
        HotelCustomersPanel.ButtonListener listener = new HotelCustomersPanel.ButtonListener();
        validationButton.addActionListener(listener);
    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String hotelSelected = hotels.getSelectedItem().toString();
            try {
                customers = applicationController.getCustomersRoom(hotelSelected);
                HotelCustomersPanel.this.removeAll();
                HotelCustomersPanel.this.setLayout(new GridLayout(0,1,5,25));
                hotelCustomersModel = new HotelCustomersModel(customers);
                JTable hotelCustomers = new JTable(hotelCustomersModel);
                JScrollPane scrollPane = new JScrollPane(hotelCustomers);
                HotelCustomersPanel.this.add(scrollPane);
                HotelCustomersPanel.this.revalidate();
                HotelCustomersPanel.this.repaint();
            }
            catch (GetHotelCustomersException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }
}
