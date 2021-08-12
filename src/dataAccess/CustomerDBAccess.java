package dataAccess;


import exception.CustomerAccessException;
import exception.GetHotelCustomersException;
import model.Customer;
import model.CustomerRoom;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDBAccess  {
    public CustomerDBAccess(){}

    public ArrayList<Customer> getCustomers() throws CustomerAccessException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select * from customer order by mail ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();
            ArrayList<Customer>customers = new ArrayList<>();
            Customer customer;
            while (data.next()){
                customer = new Customer(data.getString("mail"),data.getString("name"),data.getString("surname"),null/*todo turn data.getDate("") into gregorianCalendar*/,data.getString("phoneNumber"));
                customers.add(customer);
            }
            return customers;
        }
        catch(SQLException exception){
            throw new CustomerAccessException(exception.getMessage());
        }
    }

    public ArrayList<CustomerRoom> getCustomersRoom(String hotelSelected) throws GetHotelCustomersException {
        ArrayList<CustomerRoom> customerRooms = new ArrayList<>();
        try{
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select distinct c.name, c.surname, c.mail, ro.roomTypeName AS roomType"+
                    " from customer c, reservation r, room ro"+
                    " where c.mail = r.customerMail and r.roomHotelName = ? "+
                    " and ro.number = r.roomNumber and r.roomHotelName = ro.hotelName;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setString(1,hotelSelected);
            ResultSet data = preparedStatement.executeQuery();
            CustomerRoom customerRoom;
            while(data.next()){
                customerRoom = new CustomerRoom(data.getString("mail"),data.getString("name"),data.getString("surname"),data.getString("roomType"));
                customerRooms.add(customerRoom);
            }
        }
        catch(SQLException exception){
            throw new GetHotelCustomersException(exception.getMessage());
        }
        return customerRooms;
    }
}