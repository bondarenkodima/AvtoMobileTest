import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{

    @Test
    public void testGetClassString(){
        if (this.checkText("Hello")){
            return;
        } else if (this.checkText("hello")){
            return;
        } else {
            Assert.fail("Doesn't contain: Hello or hello");
        }
    }
    public boolean checkText(String substring){
        return this.getClassString().contains(substring);
    }
}