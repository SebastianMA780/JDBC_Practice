package Tables.Income;
import Connection.ConnectingDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IncomesD_B_Manage {
    private static ConnectingDB db_conect = new ConnectingDB();
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static void createData(Incomes income) {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            try {
                String query = "INSERT INTO `ingresos` (`porciones`,`valor`,`producto_id`) VALUES (?, ?, ?)";
                ps = ConnectingDB.prepareStatement(query);
                ps.setInt(1, income.getPortion());
                ps.setInt(2, income.getAmount());
                ps.setInt(3, income.getProduct_id());
                ps.executeUpdate();
                System.out.println("Su ganancia ha sido registrado");
            } catch (SQLException ex) {
                System.out.println(ex);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void readData() {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            String query = "SELECT * FROM `ingresos`";
            ps = ConnectingDB.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(" ID |  " + "     FECHA" + "        | PORC   |" + " VALOR");

            while ( rs.next() ) {
                String idDataBase = " " + rs.getInt("id");
                String dateDatabse = " | " + rs.getString("fecha");
                String portionsDataBase = " | " + rs.getString("porciones");
                String amountDataBase = "     | " + rs.getString("valor");


                System.out.println(idDataBase + dateDatabse + portionsDataBase + amountDataBase);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
