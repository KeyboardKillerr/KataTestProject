package core.calculations.parsers;

import core.calculations.parsers.exceptions.*;
import java.util.Map;
import java.util.regex.Pattern;

public class RomanParser implements ValueParser {
    private static final Map<Character, Integer> romanDigits = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );
    private static final Pattern regex =
            Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    private static final String[] M = {"", "M", "MM", "MMM"};
    private static final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    @Override
    public String toString(Integer value) throws ParseException {
        if (value == null) throw ParseException.fromNull();
        if (value < 1) throw new ParseException(value);
        return M[value/1000] + C[(value%1000)/100] + X[(value%100)/10] + I[value%10];
    }

    @Override
    public int toInt(String value) throws ParseException {
        if (!validate(value)) throw new ParseException(value);
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            if (i < value.length() - 1 && romanDigits.get(value.charAt(i)) < romanDigits.get(value.charAt(i + 1))) {
                result -= romanDigits.get(value.charAt(i));
            } else {
                result += romanDigits.get(value.charAt(i));
            }
        }
        return result;
    }

    @Override
    public boolean validate(String value) { return regex.matcher(value).matches(); }
}
