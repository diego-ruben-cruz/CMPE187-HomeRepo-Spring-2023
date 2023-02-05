import java.util.ArrayList;

/*
 * Description: Basic Gumball Machine Class for HW1.
 * 
 * Member names:
 * Diego Cruz
 * David Huang
 * Khoa Le
 * Nhat Tuan Nguyen
 * 
 * Course: CMPE 187
 * Section: 02
 * Homework: Writing Test Cases I 
 * Date: 4 February 2023 
 */
class GumballMachine {
    private float balance; // Stores valid coins and accumulates based on user input
    private ArrayList<String> invalidCoins; // Stores invalid coins to be returned with dispenseChange method

    /**
     * Adds a nickel to the balance of the machine
     */
    public void addNickel() {
        balance = balance + 0.05f;
    }

    /**
     * Adds a dime to the balance of the machine
     */
    public void addDime() {
        balance = balance + 0.10f;
    }

    /**
     * Adds a quarter to the balance of the machine
     */
    public void addQuarter() {
        balance = balance + 0.25f;
    }

    /**
     * Adds a penny to the change disposal unit
     */
    public void addPenny() {
        invalidCoins.add("Penny");
    }

    /**
     * Adds a half-dollar coin to the change disposal unit
     */
    public void addHalfDollar() {
        invalidCoins.add("Half-Dollar");
    }

    /**
     * Adds a dollar-coin to the change disposal unit
     */
    public void addDollar() {
        invalidCoins.add("Dollar");
    }

    /**
     * Dispenses a red gumball worth a nickel, provided there are enough funds in
     * the balance.
     */
    public void dispenseRed() {
        if (balance >= 0.05f) { // checks if there are enough funds to purchase red gumball
            System.out.println("Red Gumball dispensed");
            balance = balance - 0.05f;
        } else { // occurs if there are not enough funds in the machine
            System.out.println("No Gumball dispensed, not enough funds");
        }
        this.displayBalance(); // For debugging purposes
    }

    /**
     * Dispenses a yellow gumball worth a dime, provided there are enough funds in
     * the balance
     */
    public void dispenseYellow() {
        if (balance >= 0.10f) { // checks if there are enough funds to purchase yellow gumball
            System.out.println("Yellow Gumball Dispensed");
            balance = balance - 0.10f;
        } else { // occurs if there are not enough funds in the machine
            System.out.println("No Gumball dispensed, not enough funds");
        }
        this.displayBalance(); // For debugging purposes
    }

    /**
     * Returns the change to the user
     */
    public void dispenseChange() {
        System.out.println("Change dispensed: $" + balance); // prints out the balance of the machine
        if (invalidCoins.size() > 0) { // Checks if any invalid coins were input into the machine
            System.out.println("List of invalid coins returned:");
            for (int i = 0; i < invalidCoins.size(); i++) { // loop that prints out list of invalid coins that were
                                                            // input into the machine
                System.out.println(invalidCoins.get(i));
            }
        }
    }

    /**
     * Developer tool for testing, not necessary for CLI, though nice to have
     * Displays the balance in the machine, mainly used for debugging purposes
     */
    public void displayBalance() {
        System.out.println("Current Balance: $" + balance); // prints out balance to the cmd line
    }

}