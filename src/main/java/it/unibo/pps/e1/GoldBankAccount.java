package it.unibo.pps.e1;

public class GoldBankAccount extends BankAccountWithFee {

    private static final int MAX_DEBT = 500;
    private static final int FEE = 0;

    GoldBankAccount(BankAccount account) {
        super(account);
    }

    @Override
    public void withdraw(int amount) {
        if(this.getBalance() - amount < -MAX_DEBT) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + FEE);
    }

}
