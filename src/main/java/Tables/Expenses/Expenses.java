package Tables.Expenses;
import Tables.ManagingDb;
import Tables.Materials.MaterialsD_B_Manage;

public class Expenses extends ManagingDb {
    String quantity;
    int amount;
    int material_id;

    public static void create() {
        System.out.println("Ingrese la cantidad del material");
        String quantity = sc.nextLine();

        System.out.println("Ingrese el valor pagado");
        int amount = sc.nextInt();

        System.out.println("Ingrese el id del material /type 0 to set it Null");
        int material_id = sc.nextInt();

        Expenses expense = new Expenses();
        expense.setQuantity(quantity);
        expense.setAmount(amount);
        expense.setMaterial_id(material_id);

        ExpensesD_B_Manage.createData(expense);
    }

    public static void read() {
        ExpensesD_B_Manage.readData();
    }

    //getters and setters
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }
}
