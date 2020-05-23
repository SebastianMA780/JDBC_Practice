package Tables.CashFlow;
import TablesDAO.ITablesDao;
import java.sql.*;
import java.util.Scanner;
import Connection.DBConnection;

public class CashFlowDaoImp implements DBConnection, ITablesDao {
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void createData() {

        try (Connection connection = get_connection()) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Ingrese la fecha (yyyy-mm-dd)");
            String date = sc.nextLine();

            System.out.println("Ingresa el nuevo saldo de la caja");
            int balance = sc.nextInt();

            CashFlow cashFlow = new CashFlow();
            cashFlow.setDate(date);
            cashFlow.setBalance(balance);


            String query = "INSERT INTO `flujo_caja` (`fecha`,`saldo`) VALUES (?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, cashFlow.getDate());
            ps.setInt(2, cashFlow.getBalance());

            ps.executeUpdate();
            System.out.println("EL flujo de caja ha sido actualizado");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void readData() {

        try ( Connection connection = get_connection() ) {

            try {

                String query = "SELECT * FROM `flujo_caja`";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();
                System.out.println("ID |" + "       FECHA" + "         | SALDO  ");

                while ( rs.next() ) {
                    String idDataBase = " " + rs.getInt("id");
                    String dateDatabse = " | " + rs.getString("fecha");
                    String balanceDataBase = " \t\t | " + rs.getString("saldo");

                    System.out.println( idDataBase + dateDatabse + balanceDataBase );
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
