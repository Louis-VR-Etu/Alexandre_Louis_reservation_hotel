package business;

import dataAccess.CustomerDBAccess;
import exception.CustomerAccessException;
import exception.GetHotelCustomersException;
import model.Customer;
import model.CustomerRoom;
import java.util.ArrayList;

public class CustomerManager {
    private CustomerDBAccess customerDB;

    public CustomerManager(){customerDB = new CustomerDBAccess();}

    public ArrayList<Customer> getCustomers() throws CustomerAccessException{
        try { return customerDB.getCustomers();}
        catch (CustomerAccessException exception) {throw exception;}
    }

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

    public ArrayList<CustomerRoom> getCustomersRoom(String hotelSelected) throws GetHotelCustomersException  {
        try{
            return customerDB.getCustomersRoom( hotelSelected);
        }
        catch(GetHotelCustomersException exception){
            throw exception;
        }
    }
}
