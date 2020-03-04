package Tables.Income;

import SuperClasses.TablesDAO;
import Tables.Products.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public interface IncomesDAO extends TablesDAO {
    @Override
    default void createDataParameters(Connection connection, PreparedStatement ps) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese la porciones del producto");
            int portion = sc.nextInt();

            System.out.println("Ingrese el dinero recibido");
            int amount = sc.nextInt();

            Products product = new Products();
            System.out.println("Ingrese el id del producto correspondiente que encontrara en la tabla de abajo");
            product.read();
            int product_id = sc.nextInt();

            Incomes income = new Incomes();
            income.setPortion(portion);
            income.setAmount(amount);
            income.setProduct_id(product_id);

            String query = "INSERT INTO `ingresos` (`porciones`,`valor`,`producto_id`) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, income.getPortion());
            ps.setInt(2, income.getAmount());
            ps.setInt(3, income.getProduct_id());
            ps.executeUpdate();
            System.out.println("Su ganancia ha sido registrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    default void readDataParameters(Connection connection, PreparedStatement ps, ResultSet rs) {
        try {

            String query = "SELECT * FROM `ingresos`";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(" ID |  " + "     FECHA" + "        | PORC   |" + " VALOR");

            while ( rs.next() ) {
                String idDataBase = " " + rs.getInt("id");
                String dateDatabse = " | " + rs.getString("fecha");
                String portionsDataBase = " | " + rs.getString("porciones");
                String amountDataBase = "     | " + rs.getString("valor");


                System.out.println(idDataBase + dateDatabse + portionsDataBase + amountDataBase);
            }

        }catch (SQLException e) {
            System.out.println(e);
        }
    }
}
