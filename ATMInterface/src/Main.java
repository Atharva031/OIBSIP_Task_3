import java.util.Objects;
import java.util.Scanner;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    static int balance;
    static boolean status = true;
    static String history1 = "";
    static String history2 = "";
    static String history3 = "";

    public static void main(String[] args)
    {
        login();
        while(status)
        {

            System.out.println("=====================================");
            System.out.println("||   What would you like to do?    ||");
            System.out.println("||       1. Withdraw               ||");
            System.out.println("||       2. Deposit                ||");
            System.out.println("||       3. Transfer               ||");
            System.out.println("||       4. Transaction History    ||");
            System.out.println("||       5. Quit                   ||");
            System.out.println("=====================================");

            int option = sc.nextInt();
            switch (option) {
                case 1 -> withdraw();
                case 2 -> deposit();
                case 3 -> transfer();
                case 4 -> transactionHistory();
                case 5 -> Quit();
            }
        }
    }

    public static void login()
    {
        String initUsername = "Admin";
        String initPassword = "12345678";
        System.out.println("=====================================");
        System.out.println("||    Welcome to ICICI Bank ATM    ||");
        System.out.println("=====================================");
        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("=====================================");
        System.out.println("Enter your password: ");
        String password = sc.next();
        System.out.println("=====================================");

        if(!Objects.equals(username, initUsername) || !Objects.equals(password, initPassword))
        {
            System.out.println("Wrong username or password entered, Please try again!");
            System.exit(0);
        }
        else
        {
            System.out.println("Credentials Verified, continue to your account");

        }
    }

    public static void withdraw()
    {
        System.out.println("Enter the amount of money you want to withdraw");
        int withdrawal = sc.nextInt();
        if(withdrawal>balance)
        {
            System.out.println("Insufficient funds!");
        }
        else
        {
            System.out.println("Amount withdrawn Rs " + withdrawal + " from your bank account!");
            balance -= withdrawal;
            System.out.println("Your current balance is: Rs " + balance);
            history1 = "Withdrawal made of Rs " + withdrawal;
        }
    }

    public static void deposit()
    {
        System.out.println("Enter the amount of money you want to deposit");
        int deposited = sc.nextInt();
        if(deposited == 0)
        {
            System.out.println("No funds deposited into the account");
        }
        else
        {
            System.out.println("Amount deposited Rs " + deposited + " to your bank account!");
            balance += deposited;
            System.out.println("Your current balance is: Rs " + balance);
            history2 = "Deposit made of Rs " + deposited;
        }
    }

    public static void transfer()
    {
        int PIN = 2345;
        System.out.println("Enter the name of the recipient: ");
        String recipient = sc.next();
        System.out.println("Enter the amount to be sent: ");
        int recipientAmount = sc.nextInt();
        System.out.println("Enter your PIN: ");
        int enteredPIN = sc.nextInt();
        if(enteredPIN!=PIN)
        {
            System.out.println("Wrong PIN entered, transaction has been canceled!");
        }
        else
        {
            System.out.println("Funds transferred successfully!");
            System.out.println("Recipient: " + recipient);
            System.out.println("Amount: " + recipientAmount);
            history3 = "Transfer of funds to " + recipient + " worth Rs " + recipientAmount;
        }
    }

    public static void transactionHistory()
    {
        System.out.println(history1 + "\n" + history2 + "\n" +history3);
    }

    public static void Quit()
    {
        System.out.println("Would you like to quit the interface? Y/N");
        String decision = sc.next();
        if(decision.equals("Y"))
        {
            System.exit(0);
        }
    }
}