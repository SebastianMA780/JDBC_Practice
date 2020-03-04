package Tables.Materials;
import SuperClasses.TablesDAO;
import Tables.Suppliers.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public interface MaterialsDAO extends TablesDAO {
    @Override
    default void createDataParameters(Connection connection, PreparedStatement ps) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el nombre del producto");
            String productName = sc.nextLine();

            Suppliers supplier = new Suppliers();
            System.out.println("Ingrese el id del Proveedor correspondiente en la tabla que vera abajo");
            supplier.read();
            int supplier_id = sc.nextInt();

            Materials material = new Materials();
            material.setProductName(productName);
            material.setSupplier_id(supplier_id);

            String query = "INSERT INTO `materiales` (`producto`,`proveedor_id`) VALUES (?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, material.getProductName());
            ps.setInt(2, material.getSupplier_id());
            ps.executeUpdate();
            System.out.println("El material ha sido creado con éxito");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    default void readDataParameters(Connection connection, PreparedStatement ps, ResultSet rs) {
        try {

            String query = "SELECT * FROM `materiales`";
            ps = connection.prepareStatement(query);
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
