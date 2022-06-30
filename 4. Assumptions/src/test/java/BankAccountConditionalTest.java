import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class BankAccountConditionalTest {
    @Test
    @EnabledOnOs(OS.MAC)
    public void testMac(){

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testWindows(){

    }

    @Test
    @EnabledOnJre({JRE.JAVA_16})    //execute if running on JAVA_16
    //@DisabledOnJre({JRE.JAVA_16})   //Not RUN if running on JAVA_16
    public void testJRE(){

    }

    @Test
    @Disabled("Disabled due to maintenance")//to disable the test
    public void testDisabled(){

    }

}
