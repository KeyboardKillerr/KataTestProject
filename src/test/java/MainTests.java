import core.Main;
import org.junit.*;

public class MainTests {
    @Test
    public void sampleTests() {
        var result1 = Main.calc("1 + 2");
        var result2 = Main.calc("VI / III");
        var result3 = Main.calc("I - II");
        var result4 = Main.calc("I + 1");
        var result5 = Main.calc("1");
        var result6 = Main.calc("1 + 2 + 3");
        Assert.assertEquals("3", result1);
        Assert.assertEquals("II", result2);
        Assert.assertEquals("throws Exception", result3);
        Assert.assertEquals("throws Exception", result4);
        Assert.assertEquals("throws Exception", result5);
        Assert.assertEquals("throws Exception", result6);
    }
}
