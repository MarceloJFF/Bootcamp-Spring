package tests.entities;
import org.junit.Assert;
import org.junit.Test;

import entities.Account;
import tests.factories.AccountFactory;


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
    //Teste da exceção?

    @Test
    public void fullWithDrawShouldClearBalanceAndReturnFullBalance(){
        double expectedValue = 0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);
        double result = acc.fullWithdraw();
        Assert.assertTrue(expectedValue == acc.getBalance());
        Assert.assertTrue(result == initialBalance);
    }


    @Test
    public void withDrawShouldDecreaseBalanceWhenSufficientBalance(){
        Account acc = AccountFactory.createAccount(800.00);
        Double expectedValue = 300.00;
        acc.withdraw(500.00);
        Assert.assertEquals(expectedValue, acc.getBalance());
    }
    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance(){
        Assert.assertThrows(IllegalAccessException.class,
        ()->{
            Account acc = AccountFactory.createAccount(800.00);
            acc.withdraw(801.00);
        });
    }
}
