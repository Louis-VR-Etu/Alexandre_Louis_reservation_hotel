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

}
