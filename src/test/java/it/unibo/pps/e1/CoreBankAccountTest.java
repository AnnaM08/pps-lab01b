package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoreBankAccountTest extends BankAccountTest{

    @BeforeEach
    void init(){ this.account = new CoreBankAccount(); }

    @Test
    public void testCanWithdraw() {
        int amount = 1000;
        int withdraw = 200;
        this.account.deposit(amount);
        this.account.withdraw(withdraw);
        assertEquals(amount - withdraw, this.account.getBalance());
    }


}
