package Tables.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SuppliersD_B_Manage {
    private static DBConnection db_conect = new ConnectingDB();
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

    public static void readData() {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            String query = "SELECT * FROM `proveedores`";
            ps = ConnectingDB.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println("ID  |  " + "    NOMBRE        " + "          | TELEFONO");

            while ( rs.next() ) {
                String idDataBase = " " + rs.getInt("id");
                String nameDatabse = " | " + rs.getString("nombre");
                String phoneDataBase = " | " + rs.getInt("telefono");


                System.out.println(idDataBase + nameDatabse + phoneDataBase);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}

