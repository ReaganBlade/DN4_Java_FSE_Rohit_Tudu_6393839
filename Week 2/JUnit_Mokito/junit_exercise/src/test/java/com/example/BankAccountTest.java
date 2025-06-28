package com.example;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        // Arrange: Create an account with initial balance
        account = new BankAccount(1000.0);
        System.out.println("Setup");
    }

    @After
    public void tearDown() {
        account = null; // cleanup
        System.out.println("Teardown");
    }

    @Test
    public void testDeposit() {
        // Act
        account.deposit(500.0);

        // Assert
        assertEquals(1500.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        // Act
        account.withdraw(200.0);

        // Assert
        assertEquals(800.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        // Act
        account.withdraw(1500.0);

        // Assert (balance should stay the same)
        assertEquals(1000.0, account.getBalance(), 0.01);
    }
}
