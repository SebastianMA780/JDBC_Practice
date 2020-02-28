package Tables.Expenses;
import Connection.ConnectingDB;

import java.sql.*;
import java.util.Scanner;

public class ExpensesD_B_Manage {
    private static ConnectingDB db_conect = new ConnectingDB();
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static void createData(Expenses expense) {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            try {
                String query = "INSERT INTO `gastos` (`cantidad`,`valor`,`material_id`) VALUES (?, ?, ?)";
                ps = ConnectingDB.prepareStatement(query);
                ps.setString(1, expense.getQuantity());
                ps.setInt(2, expense.getAmount());

                if ( expense.getMaterial_id() == 0) {
                    ps.setNull(3,Types.VARCHAR);
                } else {
                    ps.setInt(3, expense.getMaterial_id());
                }

                ps.executeUpdate();
                System.out.println("Su gasto ha sido registrado");
            } catch (SQLException ex) {
                System.out.println(ex);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void readData() {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            String query = "SELECT * FROM `gastos`";
            ps = ConnectingDB.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(" ID  |" + "   FECHA" + "           | CANT  |" + " VALOR");

            while ( rs.next() ) {
                String idDataBase = " " + rs.getInt("id");
                String dateDatabse = " | " + rs.getString("fecha");
                String quantityDataBase = " | " + rs.getString("cantidad");
                String amountDataBase = " | " + rs.getString("valor");


                System.out.println(idDataBase + dateDatabse + quantityDataBase + amountDataBase);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
