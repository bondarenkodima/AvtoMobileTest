public class MainClassTest {
    static void testGetLocalNumber() {
        if (MainClass.getLocalNumber() == 14) {
            System.out.println("Check successful");
        } else if  (MainClass.getLocalNumber() != 14) {
            System.out.println("Check failed");
        }
    }
}
