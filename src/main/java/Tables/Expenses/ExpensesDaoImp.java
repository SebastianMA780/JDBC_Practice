package Tables.Expenses;
import Tables.Materials.MaterialsDaoImp;
import TablesDAO.ITablesDao;
import java.sql.*;
import java.util.Scanner;
import Connection.DBConnection;

public class ExpensesDaoImp implements DBConnection, ITablesDao {
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void createData() {

        try (Connection connection = get_connection()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese la cantidad del material");
            String quantity = sc.nextLine();

            System.out.println("Ingrese el valor pagado");
            int amount = sc.nextInt();

            ITablesDao material = new MaterialsDaoImp();
            System.out.println("Ingrese el id del material, encontrará la guia en la tabla de abajo /type 0 to set it Null");
            material.readData();
            int material_id = sc.nextInt();

            Expenses expense = new Expenses();
            expense.setQuantity(quantity);
            expense.setAmount(amount);
            expense.setMaterial_id(material_id);

            String query = "INSERT INTO `gastos` (`cantidad`,`valor`,`material_id`) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, expense.getQuantity());
            ps.setInt(2, expense.getAmount());

            if ( expense.getMaterial_id() == 0) {
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setInt(3, expense.getMaterial_id());
            }

            ps.executeUpdate();
            System.out.println("Su gasto ha sido registrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void readData() {

        try ( Connection connection = get_connection() ) {

            try {

                String query = "SELECT * FROM `gastos`";
                ps = connection.prepareStatement(query);
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

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
