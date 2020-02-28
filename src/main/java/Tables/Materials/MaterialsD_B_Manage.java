package Tables.Materials;
import Connection.ConnectingDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MaterialsD_B_Manage {
    private static ConnectingDB db_conect = new ConnectingDB();
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static void createData(Materials material) {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            try {
                String query = "INSERT INTO `materiales` (`producto`,`proveedor_id`) VALUES (?, ?)";
                ps = ConnectingDB.prepareStatement(query);
                ps.setString(1, material.getProductName());
                ps.setInt(2, material.getSupplier_id());
                ps.executeUpdate();
                System.out.println("El material ha sido creado con éxito");
            } catch (SQLException ex) {
                System.out.println(ex);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void readData() {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            String query = "SELECT * FROM `materiales`";
            ps = ConnectingDB.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println("ID | " + " PRODUCTO");

            while ( rs.next() ) {
                String idDataBase = " " + rs.getInt("id");
                String productDataBase = " | " + rs.getString("producto");

                System.out.println(idDataBase + productDataBase);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
