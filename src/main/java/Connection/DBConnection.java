package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import static Connection.DataBaseConstants.*;

public interface DBConnection {

    default Connection get_connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL + DB_NAME, ROOT,PASSWORD);
            if ( connection != null) {
                // System.out.println("Successfull connection");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
