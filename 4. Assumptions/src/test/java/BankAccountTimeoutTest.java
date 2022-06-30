import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {
    @Test
    //can put Timeout at class level as well
    @Timeout(value=500, unit = TimeUnit.MILLISECONDS)   //test should execute withing 500 ms
    public void testDeposit(BankAccount b){
        try{
            //Thread.sleep(1000); //test should fail
            Thread.sleep((100));    //test should pass
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        b.deposite(500);
        Assertions.assertEquals(500, b.getBalance());
    }

    @Test
    public void testDepositTimeOutAssertion(BankAccount b){
        b.deposite(500);
        Assertions.assertTimeout(Duration.ofMillis(50), ()->{
            Thread.sleep(100);  //will fail as it is taking 100 ms that is > 50 ms
        });
    }

}
