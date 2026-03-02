package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends BankAccountTest {

    @BeforeEach
    void init() { this.account = new GoldBankAccount(new CoreBankAccount()); }

    @Test
    public void canWithdrawWithNoFee() {
        int amount = 1000;
        int withdraw = 200;
        this.account.deposit(amount);
        this.account.withdraw(withdraw);
        assertEquals(amount - withdraw, this.account.getBalance());
    }

    @Test
    public void canHaveDebitInBalance() {
        int amount = 1000;
        int withdraw = 1200;
        this.account.deposit(amount);
        this.account.withdraw(withdraw);
        assertEquals(amount - withdraw, this.account.getBalance());
    };

    @Test
    public void canNotExceedLimitDebit(){
        int amount = 1000;
        int withdraw = 1500;
        this.account.deposit(amount);
        this.account.withdraw(withdraw);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw));
    };
}
