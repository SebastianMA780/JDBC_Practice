package Tables.CashFlow;
import Tables.Expenses.Expenses;
import Tables.Income.Incomes;
import SuperClasses.ManagingDb;

public class CashFlow extends ManagingDb implements CashFlowDAO {
    int balance;
    int income_id;
    int expense_id;

    @Override
    public void create() {
        createData();
    }

    @Override
    public void read() {
        readData();
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
