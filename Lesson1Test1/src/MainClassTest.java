import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{
        @Test
        public void testGetLocalNumber(){
            int expected = 14;
            int actual = getLocalNumber();

            Assert.assertTrue("Actual result doesn't match with expected", actual == expected);
        }
}
