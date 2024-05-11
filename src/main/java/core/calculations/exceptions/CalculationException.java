package core.calculations.exceptions;

public class CalculationException extends Exception {
    public CalculationException() { super("Something went wrong during calculations..."); }
    public CalculationException(String message) { super(message); }
}
