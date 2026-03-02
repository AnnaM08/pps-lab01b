package it.unibo.pps.e1;

public abstract class BankAccountWithFee implements BankAccount{

    protected final BankAccount base;

    BankAccountWithFee(BankAccount account){
        this.base = account;
    }

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public abstract void withdraw(int amount);

}
