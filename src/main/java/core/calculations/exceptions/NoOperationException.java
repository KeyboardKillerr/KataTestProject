package core.calculations.exceptions;

public class NoOperationException extends CalculationException {
    public NoOperationException() { super("Operation not found."); }
}
