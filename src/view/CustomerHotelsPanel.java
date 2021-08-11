package view;

import controller.ApplicationController;
import exception.CustomerAccessException;
import exception.GetCustomerHotelsException;
import model.Customer;
import model.CustomerHotelsModel;
import model.HotelPrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerHotelsPanel extends JPanel {
    private CustomerHotelsModel customerHotelsModel;
    private ArrayList<HotelPrice> hotels;

    private ApplicationController applicationController;
    private ArrayList<Customer> arrayCustomers;
    private ArrayList<String> customersStrings;

    private JSpinner spinnerPriceMin;
    private SpinnerNumberModel spinnerPriceMinModel;

    private JLabel listCustomers, priceMinLabel;
    private JComboBox customers;
    private JButton validationButton;


    public CustomerHotelsPanel() {
        this.setLayout(new GridLayout(0, 2, 5, 5));

        applicationController = new ApplicationController();

        //membersString = new ArrayList<>();
        //arrayMembers = new ArrayList<>();
        try {
            arrayCustomers = applicationController.getCustomers();
            customersStrings = applicationController.stringCustomerMail(arrayCustomers);
            listCustomers = new JLabel("List of customers");
            customers = new JComboBox(customersStrings.toArray());
            customers.setSelectedItem(0);
            customers.setMaximumRowCount(15);
            this.add(listCustomers);
            this.add(customers);
        } catch (
                CustomerAccessException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }


        priceMinLabel = new JLabel("mininum price paid");
        this.add(priceMinLabel);
        spinnerPriceMinModel = new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1);
        spinnerPriceMin = new JSpinner(spinnerPriceMinModel);
        this.add(spinnerPriceMin);


        validationButton = new JButton("Validation");
        this.add(validationButton);
        CustomerHotelsPanel.ButtonListener listener = new CustomerHotelsPanel.ButtonListener();
        validationButton.addActionListener(listener);
    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String customerSelected = customers.getSelectedItem().toString();

            Integer priceMin = spinnerPriceMinModel.getNumber().intValue();

            try {
                hotels = applicationController.getCustomerHotels(customerSelected,priceMin); //TODO


                CustomerHotelsPanel.this.removeAll();
                CustomerHotelsPanel.this.setLayout(new GridLayout(1,1,5,5));
                customerHotelsModel = new CustomerHotelsModel(hotels);
                JTable hotelsAndPrice = new JTable(customerHotelsModel);
                JScrollPane scrollPane = new JScrollPane(hotelsAndPrice);
                CustomerHotelsPanel.this.add(scrollPane);
                CustomerHotelsPanel.this.revalidate();
                CustomerHotelsPanel.this.repaint();
            }
            catch (GetCustomerHotelsException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }
}
