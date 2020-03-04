package Tables.Suppliers;
import SuperClasses.ManagingDb;

public class Suppliers extends ManagingDb implements SuppliersDAO {
    private String supplierName;
    private int phoneSupplier;

    @Override
    public void create() {
        createData();
    }

    @Override
    public void read() {
        readData();
    }


//getters and setters

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getPhoneSupplier() {
        return phoneSupplier;
    }

    public void setPhoneSupplier(int phoneSupplier) {
        this.phoneSupplier = phoneSupplier;
    }


}
