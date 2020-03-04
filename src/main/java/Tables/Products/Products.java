package Tables.Products;
import SuperClasses.ManagingDb;

public class Products extends ManagingDb implements ProductsDAO {
    String productName;
    String productFlavor;
    String productStuffed;


    @Override
    public void create() {
        createData();
    }

    @Override
    public void read() {
        readData();
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
