package kr.or.ddit.servlet04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/calculate.do")
public class CalculateServlet2 extends HttpServlet{
	//leftOp, rightOp, operator
	int leftOp = 0;
	int rightOp = 0;
	private int operator(int leftOp, int rightOp) {
		
		return leftOp * rightOp;
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/04/calculate.jsp").forward(req, resp);//jsp로 연결될 수 있게.
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//연산 결과를 돌려주는 것
		String accept = req.getHeader("Accept");
		
		String left = req.getParameter("leftOp");
		String right = req.getParameter("rightOp");
		String oper = req.getParameter("operator");
		String result = null;
		
		int sc = HttpServletResponse.SC_OK;
		String message = null;
		
		if(left != null && !left.isEmpty()) {
			try {
				int leftOp = Integer.parseInt(left);
			} catch(RuntimeException e) {
				sc = HttpServletResponse.SC_BAD_REQUEST;
				message = e.getMessage();
			}
		}
		if(right != null && !right.isEmpty()) {
			try {
				int rightOp = Integer.parseInt(right);
			} catch(RuntimeException e) {
				sc = HttpServletResponse.SC_BAD_REQUEST;
				message = e.getMessage();
			}
		}
		if(oper != null && !oper.isEmpty()) {
		}
		
		
	}
}
