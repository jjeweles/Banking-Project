import java.util.Scanner;

public class Account {
    // Variables Declaration
    int balance;
    int lastTransaction;
    String accountName;
    String accountID;

    Account(String aname, String aid) {
        accountID = aid;
        accountName = aname;
    }

    // Deposit Money
    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            lastTransaction = amount;
        }
    }

    // Withdraw Money
    void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            lastTransaction = -amount;
        }
    }

    // Print Last Transaction
    void getLastTransaction() {
        if (lastTransaction > 0) {
            System.out.println("Successfully deposited: $" + lastTransaction);
        } else if (lastTransaction < 0) {
            System.out.println("Successfully withdrew: $" + lastTransaction);
        } else {
            System.out.println("No previous transaction.");
        }
    }

    // Calculate Interest Accrued Over The Years
    void calInterest(int years) {
        double interestRate = 0.0185 * 100;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("Currently interest rates are " + (String.format("%.2f", interestRate)) + "%");
        System.out.println("In " + years + " years, your balance with interest " +
                "will be: " + newBalance);
    }

    // Display menu
    void displayMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("+-----------------------------------+");
        System.out.println("|       Welcome, " + accountName + "      |");
        System.out.println("+-----------------------------------+");
        System.out.println("|     Your account ID is: " + accountID + "     |");
        System.out.println("+-----------------------------------+");
        System.out.println("|   Please select an option:        |");
        System.out.println("|   1. Check Balance                |");
        System.out.println("|   2. Deposit Money                |");
        System.out.println("|   3. Withdraw Money               |");
        System.out.println("|   4. View Last Transaction        |");
        System.out.println("|   5. Calculate Interest           |");
        System.out.println("|   6. Exit Menu                    |");
        System.out.println("+-----------------------------------+");

        do {
            System.out.println();
            System.out.println("Select an option: ");

            char userChoice = scanner.next().charAt(0);
            option = userChoice;
            System.out.println();

            switch (userChoice) {
                // check balance
                case '1' -> {
                    System.out.println("#########################");
                    System.out.println("Balance: $" + balance);
                    System.out.println("#########################");
                }
                // deposit money
                case '2' -> {
                    System.out.println("How much would you like to deposit?");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    System.out.println();
                }
                // withdraw money
                case '3' -> {
                    System.out.println("How much would you like to withdraw?");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println();
                }
                // view last transaction
                case '4' -> {
                    System.out.println("#########################");
                    getLastTransaction();
                    System.out.println("#########################");
                    System.out.println();
                }
                // calculate years of interest
                case '5' -> {
                    System.out.println("How many years of interest would you like to see?");
                    int years = scanner.nextInt();
                    calInterest(years);
                }
                // exit program
                case '6' -> System.out.println("#########################");
                default -> System.out.println("Invalid Option, Please try again.");
            }
        } while (option != '6');
        System.out.println("Thanks for using the bank today " + accountName);
        System.out.println("Have a good day!");
    }

}
