package calculators;

import core.calculations.BoundedSingleOperationCalculator;
import core.calculations.exceptions.CalculationException;
import core.calculations.exceptions.MissingArgumentException;
import core.calculations.exceptions.NoOperationException;
import core.calculations.exceptions.ValueOutOfBoundsException;
import core.calculations.parsers.exceptions.ParseException;
import org.junit.*;

public class BoundedSingleOperationCalculatorTests {
    private final BoundedSingleOperationCalculator calculator = new BoundedSingleOperationCalculator();

    @Test(expected = ValueOutOfBoundsException.class)
    public void expressionWithTooSmallValueThrows() throws ParseException, CalculationException {
        String given = "0+1";
        calculator.calculate(given);
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void expressionWithTooBigValueThrows() throws ParseException, CalculationException {
        String given = "11+1";
        calculator.calculate(given);
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