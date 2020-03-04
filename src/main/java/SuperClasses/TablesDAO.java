package SuperClasses;
import java.sql.Connection;
import Connection.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface TablesDAO extends DBConnection {


    default void createData() {
        PreparedStatement ps = null;
        try ( Connection connection = get_connection() ) {

            createDataParameters( connection , ps);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    default void createDataParameters(Connection connection,PreparedStatement ps){
            }

    default void readData() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try ( Connection connection = get_connection() ) {

            readDataParameters( connection , ps , rs );

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    default void readDataParameters(Connection connection,PreparedStatement ps,ResultSet rs) {
    }
}
