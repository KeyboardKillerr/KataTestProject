package core.calculations;

import core.calculations.parsers.IntegerParser;
import core.calculations.parsers.ValueParser;

public class CustomNumeralCalculator extends BoundedSingleOperationCalculator {
    public CustomNumeralCalculator(ValueParser parser) { valueParser = parser; }
}
