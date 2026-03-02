package it.unibo.pps.e1;

public class SilverBankAccount extends BankAccountWithFee{

    private static final int FEE = 1;

    SilverBankAccount(BankAccount account){
        super(account);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + FEE);
    }
}
