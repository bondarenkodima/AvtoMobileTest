import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{

    @Test
    public void testGetClassNumber(){
        int expected = 45;
        int actual = this.getClassNumber();
        Assert.assertTrue("Actual result doesn't match with expected", actual > expected);
    }
}