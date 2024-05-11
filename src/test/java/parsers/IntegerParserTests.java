package parsers;

import core.calculations.parsers.IntegerParser;
import core.calculations.parsers.exceptions.ParseException;
import org.junit.*;

public class IntegerParserTests {
    private final IntegerParser parser = new IntegerParser();

    @Test
    public void successfulConversionToInteger() throws ParseException {
        String given = "1";
        Integer expected = 1;
        Integer result = parser.toInt(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void successfulConversionToIntegerOfNegativeValue() throws ParseException {
        String given = "-1";
        Integer expected = -1;
        Integer result = parser.toInt(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void successfulConversionToString() throws ParseException {
        Integer given = 1;
        String expected = "1";
        String result = parser.toString(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void successfulConversionToStringOfNegativeValue() throws ParseException {
        Integer given = -1;
        String expected = "-1";
        String result = parser.toString(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void successfulValidation() throws ParseException {
        String given = "1";
        boolean expected = true;
        boolean result = parser.validate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void unsuccessfulValidation() throws ParseException {
        String given = "A";
        boolean expected = false;
        boolean result = parser.validate(given);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = ParseException.class)
    public void conversionOfInvalidValueThrows() throws ParseException {
        String given = "A";
        parser.toInt(given);
    }
}
