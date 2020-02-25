package Tables.CashFlow;
import Tables.Expenses.Expenses;
import Tables.Income.Incomes;
import Tables.Income.IncomesD_B_Manage;
import Tables.ManagingDb;

public class CashFlow extends ManagingDb {
    int balance;
    int income_id;
    int expense_id;

    public  void create() {
        System.out.println("Ingresa el nuevo saldo de la caja");
        int balance = sc.nextInt();

        System.out.println("Ingresa el id del ingreso registrado, encontras la guia aqui abajo /type 0 for set it Null");
        Incomes.read();
        int income_id = sc.nextInt();

        System.out.println("Ingresa el id del gasto realizado, encontraras la guia aqui abajo/type 0 for set it Null");
        Expenses.read();
        int expense_id = sc.nextInt();

        CashFlow cashFlow = new CashFlow();
        cashFlow.setBalance(balance);
        cashFlow.setIncome_id(income_id);
        cashFlow.setExpense_id(expense_id);

        CashFlowD_B_Manage probando = new CashFlowD_B_Manage();
        probando.createData(cashFlow);
    }

    public  void read() {
        CashFlowD_B_Manage test = new CashFlowD_B_Manage();
        test.readData();
    }


    //getters and setters
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getIncome_id() {
        return income_id;
    }

    public void setIncome_id(int income_id) {
        this.income_id = income_id;
    }

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }
}
