package Tables.Income;
import SuperClasses.ManagingDb;
import Tables.Products.Products;

public class Incomes extends ManagingDb implements IncomesDAO {
    private int portion;
    private int amount;
    private int product_id;

    @Override
    public void create() {
        createData();
    }

    @Override
    public void read() {
        readData();
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
