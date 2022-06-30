import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// if we dont want to make beforeall and afterall method static then we can use below annotation
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfter {
    static BankAccount b;

    @BeforeAll
    //need to make static method
    public static void initialize(){
        System.out.println("Hi");
        b = new BankAccount(0, -300);
    }

    @Test
    public void testWithdraw(){
        b.withdraw(300);

        assertEquals(200, b.getBalance());
    }

    @Test
    public  void testDeposit(){
        b.deposite(500);
        assertEquals(500, b.getBalance());
    }

    @AfterAll
    //need to make static method
    public static void deallocate(){
        b = null;
        System.out.println("Bye");
    }
}
