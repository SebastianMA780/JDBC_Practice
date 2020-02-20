package Tables.Income;
import Tables.Expenses.Expenses;
import Tables.Expenses.ExpensesD_B_Manage;
import Tables.ManagingDb;

public class Income extends ManagingDb {
    int portion;
    int amount;
    int product_id;

    public static void create() {
        System.out.println("Ingrese la porciones del producto");
        int portion = sc.nextInt();

        System.out.println("Ingrese el dinero recibido");
        int amount = sc.nextInt();

        System.out.println("Ingrese el id del producto");
        int product_id = sc.nextInt();

        Income income = new Income();
        income.setPortion(portion);
        income.setAmount(amount);
        income.setProduct_id(product_id);

        IncomeD_B_Manage.createData(income);
    }

    //getters and setters
    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
