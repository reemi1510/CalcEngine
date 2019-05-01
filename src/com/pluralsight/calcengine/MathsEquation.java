package com.pluralsight.calcengine;

public class MathsEquation {

    private double leftVal;
    private double rightVal;
    private char opCode = 'a';
    private double result;

    public double getLeftVal() { return leftVal; }
    public void setLeftVal(double leftVal) { this.leftVal = leftVal; }
    public double getRightVal() { return rightVal; }
    public void setRightVal(double rightVal) { this.rightVal = rightVal; }
    public char getOpCode() { return opCode; }
    public void setOpCode(char opCode) { this.opCode = opCode; }

    public double getResult() { return result; }

    public MathsEquation() {}

    public MathsEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathsEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void execute() {
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = rightVal != 0.0d ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                System.out.println("Error - Invalid OpCode");
                result = 0.0d;
        }
    }

}