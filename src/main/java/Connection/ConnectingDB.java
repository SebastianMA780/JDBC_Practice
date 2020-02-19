package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectingDB {
    public Connection get_connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dolce_canela","root","");
            if ( connection != null) {
               // System.out.println("Successfull connection");

            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}
