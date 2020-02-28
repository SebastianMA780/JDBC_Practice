package UIMenu;
import Tables.CashFlow.CashFlow;
import Tables.Expenses.Expenses;
import Tables.Income.Incomes;
import Tables.Materials.Materials;
import Tables.Products.Products;
import Tables.Suppliers.Suppliers;
import java.util.Scanner;

public class UIMenu {
    public Scanner sc = new Scanner(System.in);

    public void PrintMenu() {
        System.out.println("\n|" + "------------------------------------------" + "|");
        System.out.println("1. Crear un dato");
        System.out.println("2. leer los datos");
        System.out.println("3. actualizar un dato");
        System.out.println("4. borrar un dato");
        System.out.println("5. Regresar al menu principal");
        System.out.println("Ingresa el número correspondiente a la acción que deseas realizar aqui abajo");

    }

    public void showMenu() {
         int optionOuterMenu = 0;
        int optionInnerMenu = 0;

        do {
            System.out.println("|" + "------------------------------------------" + "|");
            System.out.println("1. Flujo de caja");
            System.out.println("2. Ingresos");
            System.out.println("3. Productos");
            System.out.println("4. Gastos");
            System.out.println("5. Materiales");
            System.out.println("6. Proveedores");
            System.out.println("7. Finalizar el menu");
            System.out.println("Ingresa el numero correspondiente al campo que deseas modificar aqui abajo");
            optionOuterMenu = sc.nextInt();

            switch (optionOuterMenu) {
                case 1:
                    PrintMenu();
                    optionInnerMenu = sc.nextInt();

                    switch (optionInnerMenu) {
                        case 1:
                            CashFlow cashFlow = new CashFlow();
                            cashFlow.create();
                            break;
                        case 2:
                            System.out.println("Reading");
                            break;
                        case 3:
                            System.out.println("Updating");
                            break;
                        case 4:
                            System.out.println("Deleting");
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    PrintMenu();
                    optionInnerMenu = sc.nextInt();
                    switch (optionInnerMenu) {
                        case 1:
                            Incomes.create();
                            break;
                        case 2:
                            Incomes.read();
                            break;
                        case 3:
                            System.out.println("Updating");
                            break;
                        case 4:
                            System.out.println("Deleting");
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    PrintMenu();
                    optionInnerMenu = sc.nextInt();
                    switch (optionInnerMenu) {
                        case 1:
                            Products.create();
                            break;
                        case 2:
                            Products.read();
                            break;
                        case 3:
                            System.out.println("Updating");
                            break;
                        case 4:
                            System.out.println("Deleting");
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    PrintMenu();
                    optionInnerMenu = sc.nextInt();
                    switch (optionInnerMenu) {
                        case 1:
                            Expenses.create();
                            break;
                        case 2:
                            Expenses.read();
                            break;
                        case 3:
                            System.out.println("Updating");
                            break;
                        case 4:
                            System.out.println("Deleting");
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    PrintMenu();
                    optionInnerMenu = sc.nextInt();
                    switch (optionInnerMenu) {
                        case 1:
                            Materials.create();
                            break;
                        case 2:
                            Materials.read();
                            break;
                        case 3:
                            System.out.println("Updating");
                            break;
                        case 4:
                            System.out.println("Deleting");
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    PrintMenu();
                    optionInnerMenu = sc.nextInt();
                    switch (optionInnerMenu) {
                        case 1:
                            Suppliers.create();
                            break;
                        case 2:
                            Suppliers.read();
                            break;
                        case 3:
                            System.out.println("Updating");
                            break;
                        case 4:
                            System.out.println("Deleting");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

        } while( optionOuterMenu != 7 );
    }
}
