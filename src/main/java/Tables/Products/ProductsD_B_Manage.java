package Tables.Products;
import Connection.ConnectingDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductsD_B_Manage {
    private static ConnectingDB db_conect = new ConnectingDB();
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    public static Scanner sc = new Scanner(System.in);

    public static void createData(Products product) {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            try {
                String query = "INSERT INTO `productos` (`nombre`,`sabor`,`relleno`) VALUES (?, ?, ?)";
                ps = ConnectingDB.prepareStatement(query);
                ps.setString(1, product.getProductName());
                ps.setString(2, product.getProductFlavor());
                ps.setString(3,product.getProductStuffed());
                ps.executeUpdate();
                System.out.println("El producto ha sido creado");
            } catch (SQLException ex) {
                System.out.println(ex);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
