import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CodeTest {
    @Test
    public void testSayHello(){
        Codes c = new Codes();
        Assertions.assertEquals("Hello World", c.sayHello());
    }
}
