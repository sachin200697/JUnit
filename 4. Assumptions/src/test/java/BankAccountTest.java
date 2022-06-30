import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountTest {
    @Test
    public void testDeposit(){
        BankAccount b = new BankAccount(2,0);

        /*
            Assumptions are used to skip the testcase to execute that is executed by Assertions.
         */

        //assumeTrue(b!=null, "Below test will run only if BankAccount is not null");
        //if this is true then test case will execute otherwise will not execute.

        assumeFalse(b==null, "Below test will run only if BankAccount is null");   //opposite of assumeTrue

        assertEquals(4, b.deposite(2));
    }

    @Test   //for assuming that
    public void testDepositWithAssumingThat(){
        BankAccount b = new BankAccount(2,0);;
        //it will not skip the test even if condition does not meet
        assumingThat(b!=null, () -> assertEquals(4, b.deposite(2)));
    }
}
