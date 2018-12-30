import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RunJUnitTest {
    @Before
    public void doBefore(){
        System.out.println("До теста");
    }
    @Test
    public void firstTest(){
        assertEquals("1"," ");
        System.out.println("1 test");
    }
    @Test
    public void secondTest(){
        assertEquals("1","1");
        System.out.println("2 test");
    }
    @After
    public void doAfter(){
        System.out.println("После теста");
    }
}
