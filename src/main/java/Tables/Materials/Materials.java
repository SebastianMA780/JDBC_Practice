package Tables.Materials;
import SuperClasses.ManagingDb;
import Tables.Suppliers.Suppliers;

public class Materials extends ManagingDb implements MaterialsDAO{
    private String productName;
    private int supplier_id;

    @Override
    public void create() {
        createData();
    }

    @Override
    public void read() {
        readData();
    }


    //getters and setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }


}
