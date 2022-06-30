import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//here we are telling they consider @Order to decide in which order test case should execute.
// if @Order is not used then ignore that test function to execute
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrderedExucutionTest {
        static BankAccount b = new BankAccount(0,0);
        /*
            After writing testWithdraw and testDeposit testcase if we run the all tests by running
            class then testWithdraw will fail and testDeposit will pass. Because they will execute
            in the order -> testWithdraw -> testDeposit
        */

        @Test
        @Order(2)
        public void testWithdraw(){
            b.withdraw(300);

            assertEquals(200, b.getBalance());
        }

        @Test
        @Order(1)
        public  void testDeposit(){
            b.deposite(500);
            assertEquals(500, b.getBalance());
        }
}
