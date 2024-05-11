package core.calculations.exceptions;

public class MissingArgumentException extends CalculationException {
    public MissingArgumentException() { super("At least one argument is missing in expression."); }
}
