package Connection;
import java.sql.Connection;

public interface DBConnection {

    default Connection get_connection() {
        Connection connection = null;
        try {


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
