package Tables.Suppliers;
import Tables.ManagingDb;

public class Suppliers extends ManagingDb {
    String supplierName;
    int phoneSupplier;


    public static void create() {
        System.out.println("Ingrese el nombre del proveedor");
        String supplierName = sc.nextLine();

        System.out.println("Ingrese el telefono");
        int phoneSupplier = sc.nextInt();

        Suppliers supplier = new Suppliers();
        supplier.setSupplierName(supplierName);
        supplier.setPhoneSupplier(phoneSupplier);

        SuppliersD_B_Manage.createData(supplier);
    }

    public static void read() {
        SuppliersD_B_Manage.readData();
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
