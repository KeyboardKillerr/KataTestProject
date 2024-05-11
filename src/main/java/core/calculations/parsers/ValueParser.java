package core.calculations.parsers;

import core.calculations.parsers.exceptions.*;

public interface ValueParser {
    String toString(Integer value) throws ParseException;
    int toInt(String value) throws ParseException;
    boolean validate(String value);
}
