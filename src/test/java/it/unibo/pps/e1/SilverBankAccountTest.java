package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest{

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdraw() {
        int amount = 1000;
        int withdraw = 200;
        int fee = 1;
        this.account.deposit(amount);
        this.account.withdraw(withdraw);
        assertEquals(amount - withdraw - fee, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int amount = 1000;
        int withdraw = 1200;
        this.account.deposit(amount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw));
    }

}
