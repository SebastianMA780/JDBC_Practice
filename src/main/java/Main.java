import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void PrintMenu() {
        int optionInnerMenu = 0;

        do {
            System.out.println("\n1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. return to main menu");
            optionInnerMenu = sc.nextInt();

            switch (optionInnerMenu) {
                case 1:
                    System.out.println("Creating");
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

        } while (optionInnerMenu != 5);

    }

    public static void main(String[] args) {

        int optionOuterMenu = 0;

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
                      break;
                  case 2:
                      PrintMenu();
                      break;
                  case 3:
                      PrintMenu();
                      break;
                  case 4:
                      PrintMenu();
                      break;
                  case 5:
                      PrintMenu();
                      break;
                  case 6:
                      PrintMenu();
                      break;
                  default:
                      break;
              }

            } while( optionOuterMenu != 7 );
  /*      ConnectingDB connection = new ConnectingDB();
        try ( Connection testing = connection.get_connection() ) {
        } catch (SQLException e) {
            System.out.println(e);
        }*/
    }
}
