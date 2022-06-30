import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountBeforeAndAfterEach {
    static BankAccount b;

    @BeforeEach
    //will run before every test case function
    public void initialize(){
        System.out.println("Hi");
        b = new BankAccount(0, -300);
    }

    @Test
    public void testWithdraw(){
        b.withdraw(200);

        assertEquals(-200, b.getBalance());
    }

    @Test
    public  void testDeposit(){
        b.deposite(500);
        assertEquals(500, b.getBalance());
    }

    @AfterEach
    //will run after every test case function
    public void deallocate(){
        b = null;
        System.out.println("Bye");
    }
}
