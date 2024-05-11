package parsers;

import core.calculations.parsers.IntegerParser;
import core.calculations.parsers.RomanParser;
import core.calculations.parsers.exceptions.ParseException;
import org.junit.*;

public class RomanParserTests {
    private final RomanParser parser = new RomanParser();

    @Test
    public void successfulConversionToInteger() throws ParseException {
        String given = "I";
        Integer expected = 1;
        Integer result = parser.toInt(given);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = ParseException.class)
    public void conversionOfNegativeValueToIntegerThrows() throws ParseException {
        String given = "-I";
        parser.toInt(given);
    }

    @Test
    public void successfulConversionToString() throws ParseException {
        Integer given = 1;
        String expected = "I";
        String result = parser.toString(given);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = ParseException.class)
    public void conversionOfLessThanOneValueToStringThrows() throws ParseException {
        Integer given = 0;
        parser.toString(given);
    }

    @Test
    public void successfulValidation() throws ParseException {
        String given = "I";
        boolean expected = true;
        boolean result = parser.validate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void unsuccessfulValidation() throws ParseException {
        String given = "1";
        boolean expected = false;
        boolean result = parser.validate(given);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = ParseException.class)
    public void conversionOfInvalidValueThrows() throws ParseException {
        String given = "A1";
        parser.toInt(given);
    }
}
