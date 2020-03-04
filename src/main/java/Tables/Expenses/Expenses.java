package Tables.Expenses;
import SuperClasses.ManagingDb;
import Tables.Materials.Materials;

public class Expenses extends ManagingDb implements ExpensesDAO {
    private String quantity;
    private int amount;
    private int material_id;

    @Override
    public void create() {
        createData();
    }

    @Override
    public void read() {
        readData();
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
