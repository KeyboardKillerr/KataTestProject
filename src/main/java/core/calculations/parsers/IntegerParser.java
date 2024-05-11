package core.calculations.parsers;

import core.calculations.parsers.exceptions.*;
import java.util.regex.Pattern;

public class IntegerParser implements ValueParser {
    private static final Pattern regex = Pattern.compile("-?[1-9]\\d*|0");

    @Override
    public String toString(Integer value) throws ParseException {
        if (value == null) throw ParseException.fromNull();
        return value.toString();
    }

    @Override
    public int toInt(String value) throws ParseException {
        if (!validate(value)) throw new ParseException(value);
        return Integer.parseInt(value);
    }

    @Override
    public boolean validate(String value) { return regex.matcher(value).matches(); }
}
