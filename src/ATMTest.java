import java.util.*;
import java.io.*;

// ========== INTERFACE ==========
interface ATMOperations {
    boolean authenticate(String pin) throws InvalidPinException;
    double checkBalance();
    void withdraw(double amt) throws InsufficientFundsException;
    void deposit(double amt);
}

// ========== ABSTRACT CLASS ==========
abstract class BankAccount {
    protected String accNo, holder, pin;
    protected double balance;

    public BankAccount(String accNo, String holder, double bal, String pin) {
        this.accNo = accNo; this.holder = holder;
        this.balance = bal; this.pin = pin;
    }

    public abstract boolean canOverdraw();

    public double getBalance() { return balance; }
    public void deduct(double a) { balance -= a; }
    public void add(double a) { balance += a; }
    public String getPin() { return pin; }
    public void setPin(String p) { pin = p; }
}

// ========== CONCRETE CLASS 1 ==========
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accNo, String holder, double bal, String pin) {
        super(accNo, holder, bal, pin);
    }
    public boolean canOverdraw() { return false; }
}

// ========== CONCRETE CLASS 2 ==========
class CurrentAccount extends BankAccount {
    private double overdraftLimit = 50000;

    public CurrentAccount(String accNo, String holder, double bal, String pin) {
        super(accNo, holder, bal, pin);
    }
    public boolean canOverdraw() { return true; }
    public double getOverdraftLimit() { return overdraftLimit; }
}

// ========== CUSTOM EXCEPTION ==========
class InvalidPinException extends Exception {
    public InvalidPinException(String m) { super(m); }
}
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String m) { super(m); }
}

// ========== MANAGER CLASS ==========
class ATM implements ATMOperations {
    private BankAccount currentAcc;
    private boolean authenticated;
    private static final String LOG_FILE = "atm_transactions.txt";

    public void insertCard(BankAccount acc) {
        currentAcc = acc;
        authenticated = false;
        System.out.println("Card inserted: " + acc.accNo);
    }

    public boolean authenticate(String pin) throws InvalidPinException {
        if (!currentAcc.getPin().equals(pin))
            throw new InvalidPinException("Invalid PIN!");
        authenticated = true;
        System.out.println("Authenticated!");
        return true;
    }

    public double checkBalance() {
        if (!authenticated) { System.out.println("Authenticate first!"); return -1; }
        return currentAcc.getBalance();
    }

    public void withdraw(double amt) throws InsufficientFundsException {
        if (!authenticated) return;
        if (!currentAcc.canOverdraw() && amt > currentAcc.getBalance())
            throw new InsufficientFundsException("Insufficient funds! Balance: ₹" + currentAcc.getBalance());
        currentAcc.deduct(amt);
        logTransaction("WITHDRAW", amt);
        System.out.println("Withdrawn ₹" + amt + " | Balance: ₹" + currentAcc.getBalance());
    }

    public void deposit(double amt) {
        if (!authenticated) return;
        currentAcc.add(amt);
        logTransaction("DEPOSIT", amt);
        System.out.println("Deposited ₹" + amt + " | Balance: ₹" + currentAcc.getBalance());
    }

    public void changePin(String oldPin, String newPin) throws InvalidPinException {
        if (!authenticated) return;
        if (!currentAcc.getPin().equals(oldPin))
            throw new InvalidPinException("Wrong old PIN!");
        currentAcc.setPin(newPin);
        logTransaction("PIN_CHANGE", 0);
        System.out.println("PIN changed!");
    }

    private void logTransaction(String type, double amt) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(new Date() + " | " + type + " | ₹" + amt + " | Acc:" + currentAcc.accNo);
        } catch (IOException e) {
            System.out.println("Log error: " + e.getMessage());
        }
    }

    public void ejectCard() {
        currentAcc = null;
        authenticated = false;
        System.out.println("Card ejected. Thank you!");
    }
}

// ========== MAIN CLASS ==========
public class ATMTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingsAccount sa = new SavingsAccount("SA001", "Rahul Sharma", 50000, "1234");
        ATM atm = new ATM();

        atm.insertCard(sa);

        try {
            System.out.print("Enter PIN: ");
            if (atm.authenticate(sc.nextLine())) {
                System.out.println("\n1.Withdraw  2.Deposit  3.Balance  4.Change PIN  5.Exit");
                System.out.print("Choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Amount: ₹");
                        atm.withdraw(sc.nextDouble());
                        break;
                    case 2:
                        System.out.print("Amount: ₹");
                        atm.deposit(sc.nextDouble());
                        break;
                    case 3:
                        System.out.println("Balance: ₹" + atm.checkBalance());
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.print("Old PIN: ");
                        String old = sc.nextLine();
                        System.out.print("New PIN: ");
                        atm.changePin(old, sc.nextLine());
                        break;
                }
            }
        } catch (InvalidPinException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
        }

        atm.ejectCard();
        sc.close();
    }
}