package Tables.Products;
import Tables.Suppliers.Suppliers;
import TablesDAO.ITablesDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Connection.DBConnection;

public class ProductsDaoImp implements DBConnection, ITablesDao {
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void createData() {

        try (Connection connection = get_connection()) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el nombre del producto");
            String productName = sc.nextLine();

            System.out.println("Ingrese el sabor del producto");
            String productFlavor = sc.nextLine();

            System.out.println("Ingrese el sabor del producto");
            String productStuffed = sc.nextLine();

            Products product = new Products();
            product.setProductName(productName);
            product.setProductFlavor(productFlavor);
            product.setProductStuffed(productStuffed);

            String query = "INSERT INTO `productos` (`nombre`,`sabor`,`relleno`) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getProductFlavor());
            ps.setString(3, product.getProductStuffed());
            ps.executeUpdate();
            System.out.println("El producto ha sido creado");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void readData() {

        try ( Connection connection = get_connection() ) {

            try {

                String query = "SELECT * FROM `productos`";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();
                System.out.println("ID  |" + "NOMBRE" + "| SABOR " + "  | RELLENO");

                while ( rs.next() ) {
                    String idDataBase = " " + rs.getInt("id");
                    String nameDatabse = " | " + rs.getString("nombre");
                    String flavorDataBase = " | " + rs.getString("sabor");
                    String stuffedDataBase = " | " + rs.getString("relleno");


                    System.out.println(idDataBase + nameDatabse + flavorDataBase + stuffedDataBase);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
