package calculators;

import core.calculations.CustomNumeralCalculator;
import core.calculations.exceptions.CalculationException;
import core.calculations.exceptions.MissingArgumentException;
import core.calculations.exceptions.NoOperationException;
import core.calculations.parsers.RomanParser;
import core.calculations.parsers.exceptions.ParseException;
import org.junit.*;

public class RomanCustomNumeralCalculatorTests {
    private final CustomNumeralCalculator calculator = new CustomNumeralCalculator(new RomanParser());

    @Test
    public void calculationsWithRomanValuesTest() throws CalculationException, ParseException {
        String given = "II + II";
        Integer expected = 4;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = ParseException.class)
    public void expressionWithNegativeRomanValuesThrows() throws CalculationException, ParseException {
        String given = "-II + II";
        calculator.calculate(given);
    }

    @Test
    public void additionTest() throws ParseException, CalculationException {
        String given = "I+I";
        Integer expected = 2;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void subtractionTest() throws ParseException, CalculationException {
        String given = "II-I";
        Integer expected = 1;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void multiplicationTest() throws ParseException, CalculationException {
        String given = "II*II";
        Integer expected = 4;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void divisionTest() throws ParseException, CalculationException {
        String given = "II/II";
        Integer expected = 1;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void spacedExpressionTest() throws ParseException, CalculationException {
        String given = "II + II";
        Integer expected = 4;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = NoOperationException.class)
    public void expressionWithoutOperationThrows() throws ParseException, CalculationException {
        String given = "II";
        calculator.calculate(given);
    }

    @Test(expected = MissingArgumentException.class)
    public void expressionWithoutBothArgumentsThrows() throws ParseException, CalculationException {
        String given = "-";
        calculator.calculate(given);
    }

    @Test(expected = MissingArgumentException.class)
    public void expressionWithoutOneArgumentThrows() throws ParseException, CalculationException {
        String given = "+II";
        calculator.calculate(given);
    }

    @Test(expected = ParseException.class)
    public void expressionWithInvalidArgumentsThrows() throws ParseException, CalculationException {
        String given = "a+0.5";
        calculator.calculate(given);
    }
}
