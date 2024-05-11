package core.calculations;

import core.calculations.exceptions.CalculationException;
import core.calculations.exceptions.ValueOutOfBoundsException;
import core.calculations.parsers.exceptions.ParseException;

public class BoundedSingleOperationCalculator extends SingleOperationCalculator {
    @Override
    public Integer calculate(String expression) throws CalculationException, ParseException {
        var parseResult = parseExpression(expression);
        var a = parseResult.a();
        var b = parseResult.b();
        if (a < 1 || 10 < a) throw new ValueOutOfBoundsException(a);
        if (b < 1 || 10 < b) throw new ValueOutOfBoundsException(b);
        return parseResult.operation().apply(a, b);
    }
}
