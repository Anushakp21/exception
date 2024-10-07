package tryandcatch;

public class InsufficientFundsException extends Exception{
	 public InsufficientFundsException(String message) {
	        super(message);
	    }
}
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Your balance is: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}
 class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00);
        double amountToWithdraw = 600.00;

        try {
            account.withdraw(amountToWithdraw);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
