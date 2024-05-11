package core.calculations.exceptions;

public class ValueOutOfBoundsException extends CalculationException {
    public ValueOutOfBoundsException(Object value) {
        super(String.format("Value %s was out of bounds.", value.toString()));
    }
}
