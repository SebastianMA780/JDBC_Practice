package Tables.Suppliers;
import Tables.ManagingDb;
import java.util.Scanner;

public class Suppliers extends ManagingDb {
    String nombre;
    int telefono;


    public static void create() {
        System.out.println("Ingrese el nombre del proveedor");
        String supplierName = sc.nextLine();

        System.out.println("Ingrese el telefono");
        int phoneSupplier = sc.nextInt();

        Suppliers supplier = new Suppliers();
        supplier.setNombre(supplierName);
        supplier.setTelefono(phoneSupplier);

        SuppliersDataBaseManage.createData(supplier);
    }

    //getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
