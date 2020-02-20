package Tables.Products;
import Tables.ManagingDb;
import Tables.Suppliers.Suppliers;
import Tables.Suppliers.SuppliersDataBaseManage;

public class Products extends ManagingDb {
    String productName;
    String productFlavor;
    String productStuffed;

    public static void create() {
        System.out.println("Ingrese el nombre del producto");
        String productName = sc.nextLine();

        System.out.println("Ingrese el sabor del producto");
        String productFlavor = sc.nextLine();

        System.out.println("Ingrese el sabor del producto");
        String productStuffed = sc.nextLine();

        Products product = new Products();
       product.setProductName(productName);
       product.setProductFlavor(productFlavor);
       product.setProductStuffed(productStuffed);

        ProductsD_BManage.createData(product);
    }

    // getters and setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductFlavor() {
        return productFlavor;
    }

    public void setProductFlavor(String productFlavor) {
        this.productFlavor = productFlavor;
    }

    public String getProductStuffed() {
        return productStuffed;
    }

    public void setProductStuffed(String productStuffed) {
        this.productStuffed = productStuffed;
    }
}
