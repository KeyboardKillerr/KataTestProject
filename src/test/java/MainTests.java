import core.Main;
import core.calculations.exceptions.*;
import core.calculations.parsers.exceptions.*;
import org.junit.*;
import java.io.*;

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
    public void sampleTests() throws CalculationException, ParseException {
        Assert.assertEquals("3", Main.calc("1 + 2"));
        Assert.assertEquals("II", Main.calc("VI / III"));
        Assert.assertThrows(ParseException.class, () -> Main.calc("I - II"));
        Assert.assertThrows(ParseException.class, () -> Main.calc("I + 1"));
        Assert.assertThrows(NoOperationException.class, () -> Main.calc("1"));
        Assert.assertThrows(ParseException.class, () -> Main.calc("1 + 2 + 3"));
    }

    @Test
    public void mainWithArgsTest() throws CalculationException, ParseException {
        String[] given = new String[] { "2+2" };
        String expected = "4";
        Main.main(given);
        String result = outContent.toString().replace("\r\n", "");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void mainWithConsoleInputTest() throws CalculationException, ParseException {
        InputStream given = new ByteArrayInputStream("2+2".getBytes());
        System.setIn(given);
        String expected = "4";
        Main.main(null);
        String result = outContent.toString().replace("\r\n", "");
        Assert.assertEquals(expected, result);
    }
}
