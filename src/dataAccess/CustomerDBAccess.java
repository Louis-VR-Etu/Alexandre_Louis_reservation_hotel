package dataAccess;


import exception.CustomerAccessException;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;




public class CustomerDBAccess {
    public CustomerDBAccess(){}

    public ArrayList<Customer> getCustomers() throws CustomerAccessException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select * from customer";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();
            ArrayList<Customer>customers = new ArrayList<>();
            Customer customer;
            int iObject=0;
            while (data.next()){
                customer = new Customer(data.getString(""),data.getString(""),data.getString(""),null/*todo turn data.getDate("") into gregorianCalendar*/,data.getString("")); //TODO correct labels
                customers.add(customer);
            }
            return customers;
        }
        catch(SQLException exception){
            throw new CustomerAccessException(exception.getMessage());

        }
    }

}
//*/