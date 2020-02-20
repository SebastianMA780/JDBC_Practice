package Tables.Suppliers;
import Connection.ConnectingDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SuppliersD_B_Manage {
    private static ConnectingDB db_conect = new ConnectingDB();
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    public static Scanner sc = new Scanner(System.in);

    public static void createData(Suppliers supplier) {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            try {
                String query = "INSERT INTO `proveedores` (`nombre`,`telefono`) VALUES (?, ?)";
                ps = ConnectingDB.prepareStatement(query);
                ps.setString(1, supplier.getSupplierName());
                ps.setInt(2, supplier.getPhoneSupplier());
                ps.executeUpdate();
                System.out.println("El proveedor ha sido creado con éxito");
            } catch (SQLException ex) {
                System.out.println(ex);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

