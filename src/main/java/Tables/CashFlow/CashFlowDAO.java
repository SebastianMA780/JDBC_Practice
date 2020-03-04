package Tables.CashFlow;
import SuperClasses.TablesDAO;
import Tables.Expenses.Expenses;
import Tables.Income.Incomes;
import java.sql.*;
import java.util.Scanner;

public interface CashFlowDAO extends TablesDAO {
    @Override
    default void createDataParameters(Connection connection, PreparedStatement ps) {
        try {
            Scanner sc = new Scanner(System.in);

            Incomes income = new Incomes();
            System.out.println("Ingresa el id del ingreso registrado, encontras la guia aqui abajo /type 0 for set it Null");
            income.read();
            int income_id = sc.nextInt();

            Expenses expense = new Expenses();
            System.out.println("Ingresa el id del gasto realizado, encontraras la guia aqui abajo/type 0 for set it Null");
            expense.read();
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

    @Override
    default void readDataParameters(Connection connection, PreparedStatement ps, ResultSet rs) {
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
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
