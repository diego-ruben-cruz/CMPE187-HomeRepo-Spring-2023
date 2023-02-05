import java.util.Scanner;

class gumballCLI {
    public static void main(String[] args) {
        GumballMachine obj = new GumballMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Gumball Vending Machine - Select the option below:");
            System.out.println("1. Insert coin");
            System.out.println("2. Purchase Red Gumball");
            System.out.println("3. Purchase Yellow Gumball");
            System.out.println("4. View balance");
            System.out.println("5. Retrieve change");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("You entered: " + choice);

            if (choice == 1) {
                while (true) {

                    System.out.println("1. Insert a nickel");
                    System.out.println("2. Insert a dime");
                    System.out.println("3. Insert a quarter");
                    System.out.println("4. Exit to main menu");
                    System.out.print("Enter your choice: ");
                    int coinInserted = scanner.nextInt();
                    System.out.println("You entered: " + coinInserted);

                    if (coinInserted == 1) {
                        obj.addNickel();
                        System.out.println("You inserted 1 nickel");
                    } else if (coinInserted == 2) {
                        obj.addDime();
                        System.out.println("You inserted 1 dime");
                    } else if (coinInserted == 3) {
                        obj.addQuarter();
                        System.out.println("You inserted 1 quarter");
                    } else if (coinInserted == 4) {
                        break;
                    } else
                        System.out.println("Invalid choice");
                }
            }

            else if (choice == 2) {
                obj.dispenseRed();
                System.out.println("You purchased a red gumball");
            }

            else if (choice == 3) {
                obj.dispenseYellow();
                System.out.println("You purchased a yellow gumball");
            }

            else if (choice == 4) {
                obj.displayBalance();
            }

            else if (choice == 5) {
                obj.dispenseChange();
            }

            else if (choice == 6) {
                System.out.print("Exiting machine ... ");
                scanner.close();
                break;
            }

            else {
                System.out.print("Invalid choice");
            }
        }
    }
}
