import Tables.CashFlow.CashFlow;
import Tables.Expenses.Expenses;
import Tables.Income.Income;
import Tables.Materials.Materials;
import Tables.Products.Products;
import Tables.Suppliers.Suppliers;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void PrintMenu() {

            System.out.println("\n1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. return to main menu");

    }

    public static void main(String[] args) {

        int optionOuterMenu = 0;
        int optionInnerMenu = 0;

            do {
                System.out.println("|" + "------------------------------------------" + "|");
                System.out.println("Select the field you want to modify");
                System.out.println("1. Cash Flow");
                System.out.println("2. Income");
                System.out.println("3. Products");
                System.out.println("4. Expenses");
                System.out.println("5. Materials");
                System.out.println("6. Suppliers");
                System.out.println("7. End Menu");
                System.out.println("Type the number of the field down");
                optionOuterMenu = sc.nextInt();

              switch (optionOuterMenu) {
                  case 1:
                      PrintMenu();
                      optionInnerMenu = sc.nextInt();
                      switch (optionInnerMenu) {
                          case 1:
                              CashFlow.create();
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
                              Income.create();
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
                  case 3:
                      PrintMenu();
                       optionInnerMenu = sc.nextInt();
                      switch (optionInnerMenu) {
                          case 1:
                              Products.create();
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
                  case 4:
                      PrintMenu();
                      optionInnerMenu = sc.nextInt();
                      switch (optionInnerMenu) {
                          case 1:
                              Expenses.create();
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
                  case 5:
                      PrintMenu();
                      optionInnerMenu = sc.nextInt();
                      switch (optionInnerMenu) {
                          case 1:
                              Materials.create();
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
                  case 6:
                      PrintMenu();
                      optionInnerMenu = sc.nextInt();
                      switch (optionInnerMenu) {
                          case 1:
                              Suppliers.create();
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
                  default:
                      break;
              }

            } while( optionOuterMenu != 7 );
    }
}
