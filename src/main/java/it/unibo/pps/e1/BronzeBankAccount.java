package it.unibo.pps.e1;

public class BronzeBankAccount extends BankAccountWithFee{

    private static final int MAX_DEBT = 0;
    private static final int FEE = 1;

    BronzeBankAccount(BankAccount account) {
        super(account);
    }

    @Override
    public void withdraw(int amount) {
        if(this.getBalance() - amount <= MAX_DEBT) {
            throw new IllegalStateException();
        }
        if(amount > 100){
            base.withdraw(amount + 1);
        }
        base.withdraw(amount);
    }
}
