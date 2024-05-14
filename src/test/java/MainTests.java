import core.Main;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class MainTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


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

    @Test
    public void mainWithArgsTest() {
        String[] given = new String[] { "2+2" };
        String expected = "4";
        Main.main(given);
        String result = outContent.toString().replace("\r\n", "");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void mainWithConsoleInputTest() {
        InputStream given = new ByteArrayInputStream("2+2".getBytes());
        System.setIn(given);
        String expected = "4";
        Main.main(null);
        String result = outContent.toString().replace("\r\n", "");
        Assert.assertEquals(expected, result);
    }
}
