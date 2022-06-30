import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class BankAccountNestedTest {
    @Test
    public void testDeposit(){
        BankAccount b = new BankAccount(2,0);
        assertEquals(4, b.deposite(2));
    }

    //inner class test case will run only if we use @Nested anotation
    @Nested
    class BankAccountNestedTestInnerClass{
        @Test public void testDeposit(){
            BankAccount b = new BankAccount(200,0);
            assertEquals(300, b.deposite(100));
        }
    }
}
