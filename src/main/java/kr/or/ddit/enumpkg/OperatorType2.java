package kr.or.ddit.enumpkg;
	
public enum OperatorType2 {
	PLUS('+', new RealOperator() {
		public double operate(double leftOp, double rightOp) {
			return leftOp + rightOp;
		};
	}), 
	
	MINUS('-', (leftOp, rightOp)->{return leftOp-rightOp;}/*람다식*/),
	MULTIPLY('*', (leftOp, rightOp) -> {return leftOp*rightOp;}),
	DIVIDE('/', (leftOp, rightOp) -> {return leftOp/rightOp;});
	
	private OperatorType2(char sign, RealOperator operator) {
		this.sign = sign;
		this.operator = operator;
	}

	private char sign;
	private RealOperator operator; //인터페이스
	private static final String PATTERN = "%f %s %f = %f";
	
	public char getSign() {
		return sign;
	}
	
	public double operate(double leftOp, double rightOp) {
		return operator.operate(leftOp, rightOp);
	}
	
	public String makeExpression(double leftOp, double rightOp) {
		return String.format(PATTERN, leftOp, sign, rightOp, operate(leftOp, rightOp));
	}
	
//	public double operate(double leftOp, double rightOp) {
//		//객체가 누구냐에 따라 달라지기 때문에 하드코딩은 할 수 없다.
//	}
}
