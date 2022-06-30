import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")
public class BankAccountTest {
    @Test
    @DisplayName("Withdraw 300 successfully")   //to give some name for methods
    public void testWithdraw(){
        BankAccount b = new BankAccount(500, -1000);
        b.withdraw(300);

        assertEquals(200, b.getBalance());
    }

    @Test
    public void testNoWithdrawBelowMinimum(){
        BankAccount b = new BankAccount(10, 0);
        assertThrows(RuntimeException.class, ()-> b.withdraw(500));
    }

    @Test
    @DisplayName("Deposit 300 successfully")    //to give some name for methods
    public void testDeposit(){
        BankAccount b = new BankAccount(500, 0);
        b.deposit(300);

        assertEquals(800, b.getBalance());
    }

    @Test
    //test if method taking more time than expected
    public void testDepositeTimeout(){
        BankAccount b = new BankAccount(10,0);
        assertTimeout(Duration.ofNanos(1), ()->b.deposit(10)); //for 1 nano second
    }

    @Test
    @DisplayName("No exception for withdraw and deposite")
    public void testWithdrawAndDepositWithoutExceptions(){
        BankAccount b = new BankAccount(10, 0);
        assertAll(()-> b.deposit(20), ()->b.withdraw(15));
    }

    @Test
    @DisplayName("Test Withdraw on Negative")
    public void  testWithdrawNotStuckAtZero(){
        BankAccount b = new BankAccount(500, -1000);
        b.withdraw(-800);
        assertNotEquals(0, b.getBalance());
    }

    @Test
    public void testIsActive(){
        BankAccount b = new BankAccount(10, 0);
        assertTrue(b.isActive());
    }

    @Test
    public void testHolderNameSet(){
        BankAccount b = new BankAccount(10, 0);
        b.setAccountHolderName("Sachin");
        assertNotNull(b.getAccountHolderName());
    }

    @Test
    public void testOthers(){
        //0.33 not equal to 1/3, but sometimes we need to assure that these are equal
        // so in that case use delta value as third argument for assertEquals

        //assertEquals(0.33, 1.0/3);
        assertEquals(0.33, 1.0/3, 0.01);

        //provide default message
        //assertEquals(0.33, 1.0/3, "Opps, test case failed!!");

        //if we want some testcase to implecitely failed
        //fail();
    }
}
