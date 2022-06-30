import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.time.Duration;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @Test
    public void testDeposit1(BankAccount b){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        b.deposite(500);
        Assertions.assertEquals(500, b.getBalance());
    }

    @Test
    public void testDeposit2(BankAccount b){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        b.deposite(500);
        Assertions.assertEquals(500, b.getBalance());
    }

    @Test
    public void testDeposit3(BankAccount b){
        try{
            //Thread.sleep(1000); //test should fail
            Thread.sleep(1500);    //test should pass
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        b.deposite(500);
        Assertions.assertEquals(500, b.getBalance());
    }
}
