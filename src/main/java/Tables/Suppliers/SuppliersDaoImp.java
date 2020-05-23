package Tables.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Connection.DBConnection;
import TablesDAO.ITablesDao;

public class SuppliersDaoImp implements DBConnection, ITablesDao {
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void createData() {

        try (Connection connection = get_connection()) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el nombre del proveedor");
            String supplierName = sc.nextLine();

            System.out.println("Ingrese el telefono");
            int phoneSupplier = sc.nextInt();

            Suppliers supplier = new Suppliers();
            supplier.setSupplierName(supplierName);
            supplier.setPhoneSupplier(phoneSupplier);

            String query = "INSERT INTO `proveedores` (`nombre`,`telefono`) VALUES (?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, supplier.getSupplierName());
            ps.setInt(2, supplier.getPhoneSupplier());
            ps.executeUpdate();
            System.out.println("El proveedor ha sido creado con éxito");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void readData() {

        try ( Connection connection = get_connection() ) {

            try {

                String query = "SELECT * FROM `proveedores`";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();
                System.out.println("ID  |  " + "    NOMBRE        " + "          | TELEFONO");

                while (rs.next()) {
                    String idDataBase = " " + rs.getInt("id");
                    String nameDatabse = " | " + rs.getString("nombre");
                    String phoneDataBase = " | " + rs.getInt("telefono");


                    System.out.println(idDataBase + nameDatabse + phoneDataBase);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
