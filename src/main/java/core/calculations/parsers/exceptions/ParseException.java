package core.calculations.parsers.exceptions;

public class ParseException extends Exception {
    public ParseException(Integer value) { super(String.format("Unable to parse %d", value)); }
    public ParseException(String value) { super(String.format("Unable to parse %s", value)); }
    public static ParseException fromNull() { return new ParseException("NULL"); }
}
