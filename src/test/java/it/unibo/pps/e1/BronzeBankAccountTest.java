package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends BankAccountTest{

    @BeforeEach
    void init() { this.account = new BronzeBankAccount(new CoreBankAccount()); }

    @Test
    public void canNotHaveDebits(){
        int amount = 1000;
        int withdraw = 1000;
        this.account.deposit(amount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw));
    }

    @ParameterizedTest
    @CsvSource({
            "120, 100, 19",
            "120, 10, 110"
    })
    public void canWithdraw(int amount, int withdraw, int expectedBalance){
        this.account.deposit(amount);
        this.account.withdraw(withdraw);
        assertEquals(amount - withdraw, this.account.getBalance());
    }
}
