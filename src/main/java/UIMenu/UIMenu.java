package UIMenu;
import Tables.CashFlow.CashFlow;
import Tables.CashFlow.CashFlowDaoImp;
import Tables.Expenses.Expenses;
import Tables.Expenses.ExpensesDaoImp;
import Tables.Income.Incomes;
import Tables.Income.IncomesDaoImp;
import Tables.Materials.Materials;
import Tables.Materials.MaterialsDaoImp;
import Tables.Products.Products;
import Tables.Products.ProductsDaoImp;
import Tables.Suppliers.Suppliers;
import Tables.Suppliers.SuppliersDaoImp;
import TablesDAO.ITablesDao;

import java.util.Scanner;

public class UIMenu  {
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
            System.out.println("Ingresa el número correspondiente al campo que deseas modificar aqui abajo");
            optionOuterMenu = sc.nextInt();

            switch (optionOuterMenu) {
                case 1:
                    PrintMenu();
                    optionInnerMenu = sc.nextInt();
                    ITablesDao cashFlow = new CashFlowDaoImp();
                    switch (optionInnerMenu) {
                        case 1:
                            cashFlow.createData();
                            break;
                        case 2:
                            cashFlow.readData();
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
                    ITablesDao income = new IncomesDaoImp();
                    switch (optionInnerMenu) {
                        case 1:
                            income.createData();
                            break;
                        case 2:
                            income.readData();
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
                    ITablesDao product = new ProductsDaoImp();
                    switch (optionInnerMenu) {
                        case 1:
                            product.createData();
                            break;
                        case 2:
                            product.readData();
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
                    ITablesDao expense = new ExpensesDaoImp();
                    switch (optionInnerMenu) {
                        case 1:
                            expense.createData();
                            break;
                        case 2:
                            expense.readData();
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
                    ITablesDao material = new MaterialsDaoImp();
                    switch (optionInnerMenu) {
                        case 1:
                            material.createData();
                            break;
                        case 2:
                            material.readData();
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
                    ITablesDao supplier = new SuppliersDaoImp();
                    switch (optionInnerMenu) {
                        case 1:
                            supplier.createData();
                            break;
                        case 2:
                            supplier.readData();
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
