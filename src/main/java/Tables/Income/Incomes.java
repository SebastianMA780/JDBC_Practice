package Tables.Income;
import Tables.ManagingDb;
import Tables.Products.Products;

import java.util.Scanner;

public class Incomes extends ManagingDb {
    int portion;
    int amount;
    int product_id;

    public static void create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la porciones del producto");
        int portion = sc.nextInt();

        System.out.println("Ingrese el dinero recibido");
        int amount = sc.nextInt();

        System.out.println("Ingrese el id del producto correspondiente que encontrara en la tabla de abajo");
        Products.read();
        int product_id = sc.nextInt();

        Incomes income = new Incomes();
        income.setPortion(portion);
        income.setAmount(amount);
        income.setProduct_id(product_id);

        IncomesD_B_Manage.createData(income);
    }

    public static void read() {
        IncomesD_B_Manage.readData();
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
