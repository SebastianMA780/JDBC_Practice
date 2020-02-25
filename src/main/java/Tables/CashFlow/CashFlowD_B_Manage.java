package Tables.CashFlow;
import Connection.ConnectingDB;
import java.sql.*;
import java.util.Scanner;

public class CashFlowD_B_Manage {
    private  ConnectingDB db_conect = new ConnectingDB();
    private  PreparedStatement ps = null;
    public  ResultSet rs = null;
    public  Scanner sc = new Scanner(System.in);

    public   void createData(CashFlow cashFlow) {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            try {
                String query = "INSERT INTO `flujo_caja` (`saldo`,`ingreso_id`,`gasto_id`) VALUES (?, ?, ?)";
                ps = ConnectingDB.prepareStatement(query);
                ps.setInt(1, cashFlow.getBalance());

                if ( cashFlow.getIncome_id() == 0) {
                    ps.setNull(2, Types.VARCHAR);
                } else {
                    ps.setInt(2, cashFlow.getIncome_id());
                }
                if ( cashFlow.getExpense_id() == 0) {
                   ps.setNull(3,Types.VARCHAR);
                } else {
                    ps.setInt(3, cashFlow.getExpense_id());
                }

                ps.executeUpdate();
                System.out.println("EL flujo de caja ha sido actualizado");
            } catch (SQLException ex) {
                System.out.println(ex);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public  void readData() {
        try (Connection ConnectingDB = db_conect.get_connection()) {

            String query = "SELECT * FROM `flujo_caja`";
            ps = ConnectingDB.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println("ID |" + "       FECHA" + "         | SALDO  ");

            while ( rs.next() ) {
                String idDataBase = " " + rs.getInt("id");
                String dateDatabse = " | " + rs.getString("fecha");
                String balanceDataBase = " | " + rs.getString("saldo");



                System.out.println( idDataBase + dateDatabse + balanceDataBase );
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
