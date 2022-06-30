import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {

    @ParameterizedTest  //to pass parameters
    @ValueSource(ints = {400, 500, 600, 700})
    public void testDeposit(int amount, BankAccount b){ //no need to initialize b with BankAccount object
        b.deposite(amount);
        assertEquals(amount, b.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
    public void testDayOfWeek(DayOfWeek day){
        assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
    @CsvSource({"100, Sachin", "200, Pradeep", "300, Naman"})
    public void depositAndNameTest(double amount, String name, BankAccount b){
        b.deposite(amount);
        b.setHoldeName(name);
        assertEquals(amount, b.getBalance());
        assertEquals(name, b.getHoldeName());
    }

    //to test with csv file -> create a folder resources in test
    @ParameterizedTest
    @CsvFileSource(resources = "testcases.csv", delimiter = ',')
    //for delimiter if it is ',' then no need to specify but for other delimiter like ; or - or !
    // we can specify them>
    public void depositAndNameWithCSVFileTest(double amount, String name, BankAccount b){
        b.deposite(amount);
        b.setHoldeName(name);
        assertEquals(amount, b.getBalance());
        assertEquals(name, b.getHoldeName());
    }
}
