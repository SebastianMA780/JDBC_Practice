package Tables.Materials;
import Tables.ManagingDb;

public class Materials extends ManagingDb {
    String productName;
    int supplier_id;

    public static void create() {
        System.out.println("Ingrese el nombre del producto");
        String productName = sc.nextLine();

        System.out.println("Ingrese el id del Producto");
        int supplier_id = sc.nextInt();

        Materials material = new Materials();
        material.setProductName(productName);
        material.setSupplier_id(supplier_id);


        MaterialsD_B_Manage.createData(material);
    }

    public static void read() {
        MaterialsD_B_Manage.readData();
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
