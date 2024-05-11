package core.calculations;

import core.calculations.exceptions.CalculationException;
import core.calculations.parsers.exceptions.*;

public interface Calculator {
    Integer calculate(String expression) throws CalculationException, ParseException;
}
