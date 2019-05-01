package com.pluralsight.calcengine;

public class CalculateHelper {
    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';

    MathsCommand command;
    double leftValue;
    double rightValue;
    double result;

    public void process(String statement) {
        String[] parts = statement.split(" ");
        String commandString = parts[0];
        leftValue = Double.parseDouble(parts[1]);
        rightValue = Double.parseDouble(parts[2]);

        setCommandFromString(commandString);

        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Subtractor(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();
    }

    private void setCommandFromString(String commandString) {
        if(commandString.equalsIgnoreCase(MathsCommand.Add.toString()))
            command = MathsCommand.Add;
        else if (commandString.equalsIgnoreCase(MathsCommand.Subtract.toString()))
            command = MathsCommand.Subtract;
        else if (commandString.equalsIgnoreCase(MathsCommand.Multiply.toString()))
            command = MathsCommand.Multiply;
        else if (commandString.equalsIgnoreCase(MathsCommand.Divide.toString()))
            command = MathsCommand.Divide;
    }

    @Override
    public String toString() {
        char symbol = ' ';
        switch (command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUBTRACT_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();

    }
}
