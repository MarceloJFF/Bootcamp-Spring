package tests.entities;
import org.junit.Assert;
import org.junit.Test;

import entities.Account;


public class AccounTests {
    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){
        Double amount = 200.00;
        Double expectedValue = 196.00;
        Account acc = new Account(1L,0.0);

        acc.deposit(amount);

        Assert.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount(){
        Double expectedValue = 100.00;

        Account acc = new Account(1L,expectedValue);
        Double amount = -200.00;
        acc.deposit(amount);
        Assert.assertEquals(expectedValue, acc.getBalance());
    }
}
