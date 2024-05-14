package core;

import core.calculations.exceptions.*;
import core.calculations.parsers.exceptions.*;
import core.calculations.*;
import core.calculations.parsers.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws CalculationException, ParseException {
        if (args != null && args.length != 0) System.out.println(calc(args[0]));
        else System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) throws CalculationException, ParseException {
        var intParser = new IntegerParser();
        var romanParser = new RomanParser();
        var decimalCalculator = new CustomNumeralCalculator(intParser);
        var romanCalculator = new CustomNumeralCalculator(romanParser);
        var result = "";
        try {
            result = intParser.toString(decimalCalculator.calculate(input));
        } catch (CalculationException | ParseException ignore) { }
        if (!result.isEmpty()) return result;
        return romanParser.toString(romanCalculator.calculate(input));
    }
}