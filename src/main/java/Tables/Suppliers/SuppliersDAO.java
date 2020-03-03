package Tables.Suppliers;
import Connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SuppliersDAO extends DBConnection {

    default void create(Suppliers supplier) {

        try (Connection connection = get_connection()) {

            try {
                PreparedStatement ps = null;
                String query = "INSERT INTO `proveedores` (`nombre`,`telefono`) VALUES (?, ?)";
                ps = connection.prepareStatement(query);
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


