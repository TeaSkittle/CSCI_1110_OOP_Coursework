package Final;

class Test {
	public static void main(String[] args) {
		Calc calc = new Calc();
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println( calc.run( tokens ));
		calc.repl();
	}
}