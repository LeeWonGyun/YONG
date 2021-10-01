package kr.or.ddit.enumpkg;
	

@FunctionalInterface 
public interface RealOperator { //functional interface라고 불린다. -> 인터페이스 안에 행위메서드가 1개 있을 때
	public double operate(double leftOp, double rightOp);
}
