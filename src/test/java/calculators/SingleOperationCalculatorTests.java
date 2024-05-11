package calculators;

import core.calculations.SingleOperationCalculator;
import core.calculations.exceptions.CalculationException;
import core.calculations.exceptions.MissingArgumentException;
import core.calculations.exceptions.NoOperationException;
import core.calculations.parsers.exceptions.ParseException;
import org.junit.*;

public class SingleOperationCalculatorTests {
    private final SingleOperationCalculator calculator = new SingleOperationCalculator();

    @Test
    public void negativeNumbersTest() throws ParseException, CalculationException {
        String given = "-2+-2";
        Integer expected = -4;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void additionTest() throws ParseException, CalculationException {
        String given = "1+1";
        Integer expected = 2;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void subtractionTest() throws ParseException, CalculationException {
        String given = "1-1";
        Integer expected = 0;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void multiplicationTest() throws ParseException, CalculationException {
        String given = "2*2";
        Integer expected = 4;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void divisionTest() throws ParseException, CalculationException {
        String given = "2/2";
        Integer expected = 1;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void spacedExpressionTest() throws ParseException, CalculationException {
        String given = "2 + 2";
        Integer expected = 4;
        Integer result = calculator.calculate(given);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = NoOperationException.class)
    public void expressionWithoutOperationThrows() throws ParseException, CalculationException {
        String given = "2";
        calculator.calculate(given);
    }

    @Test(expected = MissingArgumentException.class)
    public void expressionWithoutBothArgumentsThrows() throws ParseException, CalculationException {
        String given = "-";
        calculator.calculate(given);
    }

    @Test(expected = MissingArgumentException.class)
    public void expressionWithoutOneArgumentThrows() throws ParseException, CalculationException {
        String given = "+2";
        calculator.calculate(given);
    }

    @Test(expected = ParseException.class)
    public void expressionWithInvalidArgumentsThrows() throws ParseException, CalculationException {
        String given = "a+0.5";
        calculator.calculate(given);

    }
}
