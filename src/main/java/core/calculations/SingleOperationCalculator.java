package core.calculations;

import core.calculations.exceptions.*;
import java.util.Map;
import java.util.function.BiFunction;
import core.calculations.parsers.IntegerParser;
import core.calculations.parsers.ValueParser;
import core.calculations.parsers.exceptions.*;

public class SingleOperationCalculator implements Calculator {
    protected ValueParser valueParser = new IntegerParser();

    protected static final Map<Character, BiFunction<Integer, Integer, Integer>> operations = Map.of(
            '+', SingleOperationCalculator::add,
            '-', SingleOperationCalculator::subtract,
            '*', SingleOperationCalculator::multiply,
            '/', SingleOperationCalculator::divide
    );

    public Integer calculate(String expression) throws CalculationException, ParseException {
        var parseResult = parseExpression(expression);
        return parseResult.operation().apply(parseResult.a(), parseResult.b());
    }

    protected ParseResult parseExpression(String expression) throws CalculationException, ParseException {
        expression = expression.replace(" ", "");
        int index = -1;
        for (int i = 0; i < expression.length(); i++) {
            if (operations.containsKey(expression.charAt(i))) {
                if (i == 0
                    && expression.charAt(i) == '-'
                    && expression.length() > 1
                    && valueParser.validate(String.valueOf(expression.charAt(i + 1)))) continue;
                index = i;
                break;
            }
        }
        if (index == -1) throw new NoOperationException();
        BiFunction<Integer, Integer, Integer> operation = operations.get(expression.charAt(index));
        String firstNum = expression.substring(0, index);
        String secondNum = expression.substring(index + 1);
        if (firstNum.isEmpty() || secondNum.isEmpty()) throw new MissingArgumentException();
        return new ParseResult(valueParser.toInt(firstNum), valueParser.toInt(secondNum), operation);
    }

    protected static int add(int a, int b) { return a + b; }
    protected static int subtract(int a, int b) { return a - b; }
    protected static int multiply(int a, int b) { return a * b; }
    protected static int divide(int a, int b) { return a / b; }

    protected record ParseResult(
            Integer a,
            Integer b,
            BiFunction<Integer, Integer, Integer> operation) {
        public Integer a() { return a; }
        public Integer b() { return b; }
        public BiFunction<Integer, Integer, Integer> operation() { return operation; }
    }
}
