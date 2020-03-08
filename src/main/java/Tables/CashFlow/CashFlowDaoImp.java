package Tables.CashFlow;
import Tables.Expenses.ExpensesDaoImp;
import Tables.Income.IncomesDaoImp;
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

            ITablesDao income = new IncomesDaoImp();
            System.out.println("Ingresa el id del ingreso registrado, encontras la guia aqui abajo /type 0 for set it Null");
            income.readData();
            int income_id = sc.nextInt();

            ITablesDao expense = new ExpensesDaoImp();
            System.out.println("Ingresa el id del gasto realizado, encontraras la guia aqui abajo/type 0 for set it Null");
            expense.readData();
            int expense_id = sc.nextInt();

            System.out.println("Ingresa el nuevo saldo de la caja");
            int balance = sc.nextInt();

            CashFlow cashFlow = new CashFlow();
            cashFlow.setBalance(balance);
            cashFlow.setIncome_id(income_id);
            cashFlow.setExpense_id(expense_id);

            String query = "INSERT INTO `flujo_caja` (`saldo`,`ingreso_id`,`gasto_id`) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(query);
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
                    String balanceDataBase = " | " + rs.getString("saldo");

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
