package business;

import dataAccess.CustomerDBAccess;
import exception.CustomerAccessException;
import model.Customer;

import java.util.ArrayList;

public class CustomerManager {
    private CustomerDBAccess customerDB;
    public CustomerManager(){customerDB = new CustomerDBAccess();}

    public ArrayList<Customer> getCustomers() throws CustomerAccessException{
        try { return customerDB.getCustomers();}
        catch (CustomerAccessException exception) {throw exception;}

    }
/*
    public ArrayList<String> stringCustomer(ArrayList<Customer> customers) {
        ArrayList<String> customersName = new ArrayList<>();

        for (int iCustomer = 0 ; iCustomer < customers.size() ; iCustomer++) {
            customersName.add(customers.get(iCustomer).getName() + ", " + customers.get(iCustomer).getSurname() + ", " + customers.get(iCustomer).getBirthDate() + ", " + customers.get(iCustomer).getMail() + ", " + customers.get(iCustomer).getPhoneNumber());
        }
        return customersName;
    }
*/
    public ArrayList<String> stringCustomerMail(ArrayList<Customer> customers) {
        ArrayList<String> customerMails = new ArrayList<>();

        for (int iCustomer = 0 ; iCustomer < customers.size() ; iCustomer++) {
            customerMails.add(customers.get(iCustomer).getMail());
        }
        return customerMails;
    }

    public Customer researchCustomer(String customerString, ArrayList<Customer> customers) {
        boolean isFound = false;
        int iCustomer = 0;
        while (iCustomer < customers.size() && !isFound) {
            isFound = customerString.compareTo(customers.get(iCustomer).getMail()) == 0;
            iCustomer++;
        }
        return customers.get(iCustomer-1);
    }
}
