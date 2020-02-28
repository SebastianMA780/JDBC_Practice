package Tables.Products;
import Tables.ManagingDb;

import java.util.Scanner;

public class Products extends ManagingDb {
    String productName;
    String productFlavor;
    String productStuffed;

    public static void create() {
        Scanner sc = new Scanner(System.in);
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

        ProductsD_B_Manage.createData(product);
    }

    public static void read() {
        ProductsD_B_Manage.readData();
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
