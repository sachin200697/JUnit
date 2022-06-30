import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class) //for default object initialization (by default)
//for function arguments: for example testDeposit
public class BankAccountDITest {

    @RepeatedTest(5)    //run a test multiple times
    public void testDeposit(BankAccount b){ //no need to initialize b with BankAccount object
        b.deposite(500);
        assertEquals(500, b.getBalance());
    }

    @Test
    @RepeatedTest(5)    //run a test multiple times
    public void testDepositRepetitionInfo(BankAccount b, RepetitionInfo rinfo){ //no need to initialize b with BankAccount object
        b.deposite(500);
        assertEquals(500, b.getBalance());
        System.out.println("Nr:"+rinfo.getCurrentRepetition());
    }
}
