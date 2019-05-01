package com.pluralsight.calcengine;

public class Main {

    public static void main(String[] args) {

//    	MathsEquation testEquation = new MathsEquation();
//    	testEquation.execute();
//    	System.out.print("test=");
//    	System.out.println(testEquation.getResult());

		MathsEquation[] equations = new MathsEquation[4];
		equations[0] = new MathsEquation('d', 00.0d, 50.0d);
		equations[1] = new MathsEquation('a', 25.0d, 92.0d);
		equations[2] = new MathsEquation('s', 225.0d, 17.0d);
		equations[3] = new MathsEquation('m', 11.0d, 3.0d);

		for (MathsEquation equation : equations) {
			equation.execute();
			System.out.print("result = ");
			System.out.println(equation.getResult());
		}
    }

//    public static MathsEquation create(double leftVal, double rightVal, char opCode) {
//    	MathsEquation equation = new MathsEquation();
//    	equation.setLeftVal(leftVal);
//    	equation.setRightVal(rightVal);
//    	equation.setOpCode(opCode);
//
//    	return equation;
//	}
}
