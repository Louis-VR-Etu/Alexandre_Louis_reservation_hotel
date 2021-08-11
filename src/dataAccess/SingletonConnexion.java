package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SingletonConnexion {
    private static Connection connexionUnique;

    public static Connection getInstance() throws SQLException {
        if (connexionUnique == null) {

                try {
                    connexionUnique = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanager", "root", "rootpassword"); //TODO correct database url
                } catch (SQLException exception) {
                    throw exception;
                }
            }

        return connexionUnique;

    }


}
