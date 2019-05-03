package com.pluralsight.myapp;

import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathsEquation;
import com.pluralsight.calcengine.MathsProcessing;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.PowerOf;
import com.pluralsight.calcengine.Subtractor;

public class Main {

    public static void main(String[] args) {
//		useCalculateHelper();

		String[] statements = {
				"add 25.0 92.0",
				"power 5.0 2.0"
		};

		DynamicHelper helper = new DynamicHelper(new MathsProcessing[] {
				new Adder(),
				new PowerOf()
		});

		for (String statement:statements) {
			String output = helper.process(statement);
			System.out.println(output);
		}
    }

	private static void useCalculateHelper() {
		String[] statements = {
				"add 1.0",
				"add xx 25.0",
				"addX 0.0 0.0",
				"divide 100.0 50.0",
				"add 25.0 92.0",
				"subtract 225.0 17.0",
				"multiply 11.0 3.0"
		};

		CalculateHelper helper = new CalculateHelper();
		for (String statement : statements) {
			try {
				helper.process(statement);
				System.out.println(helper);
			} catch (InvalidStatementException e) {
				System.out.println(e.getMessage());
				if (e.getCause() != null)
					System.out.println(" Original exception: " + e.getCause().getMessage());
			}

		}

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

		System.out.println();
		System.out.println("Using overloads");
		System.out.println();

		double leftDouble = 9.0d;
		double rightDouble = 4.0d;

		MathsEquation equationOverload = new MathsEquation('d');

		equationOverload.execute(leftDouble, rightDouble);

		System.out.print("Result= ");
		System.out.println(equationOverload.getResult());

		System.out.println();
		System.out.println("Using inheritance");
		System.out.println();

		CalculateBase[] calculators = {
				new Divider(100.0d, 50.0d),
				new Adder(25.0d, 92.0d),
				new Subtractor(225.0d, 17.0d),
				new Multiplier(11.0d, 3.0d)
		};

		for (CalculateBase calculator : calculators) {
			calculator.calculate();

			System.out.print("Result= ");
			System.out.println(calculator.getResult());
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
