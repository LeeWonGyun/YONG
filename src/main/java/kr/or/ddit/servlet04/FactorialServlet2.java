package kr.or.ddit.servlet04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/factorial2.do")
//WEB-INF에 있는 jsp를 불러올 servlet이 필요. -> ui를 클라이언트에게 제공하기 위해

public class FactorialServlet2 extends HttpServlet{
	
	   private long factorial(int operand){
	      if(operand < 0)
	         throw new IllegalArgumentException("연산 수행 불가");   // 예외를 발생시킨다. 
	      if(operand <= 1){   // 1이나 0을 받은 경우 => 그대로 돌려줘도 된다. (factorial)
	         return operand;
	      }else{
	         return operand * factorial(operand - 1);   // 10 * 9 * 8 * ...   
	      }
	   }
	
	  

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/04/factorial2.jsp").forward(req, resp); //redirection을 사용할 경우에는 클래스패스 절대경로가 필요하다.
		//forward와 include
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accept = request.getHeader("Accept");
		
		
		String param = request.getParameter("operand");
		   int sc = HttpServletResponse.SC_OK;   // 정상적으로 넘어온 경우 200    
		   String message = null;
		   long result = -1;
		   if(param != null && !param.isEmpty()){   // null체크 하나만으로는 데이터가 비어있는지 확인할 수 없다. (화이트스페이스때문)
		      try{
		         int operand = Integer.parseInt(param);   // 넘어온 파라미터가 Integer형태로 파싱할 수 있는지 검증이 필요 
		         result = factorial(operand);   // catch에 걸리지 않은 경우(제대로 넘어온 경우)
		         request.setAttribute("result", result);   // 연산의 결과를 넣어준다. => 결과는 아래 form태그쪽에서 출력해본다. 
		      }catch(RuntimeException e){   // RuntimeException (UnCheckedException들의 부모이므로 해당 예외는 다 캐치함)
		         sc = HttpServletResponse.SC_BAD_REQUEST;   // 클라이언트쪽에서 발생한 에러 => 400번대 에러 발생 
		         message = e.getMessage();
		      }
		   }
		   if(sc != HttpServletResponse.SC_OK){   // 검증에 통과하지 못한 경우
			   response.sendError(sc, message);
			   return;
		   }
		   if(accept.contains("json")) {
//			   Marshalling
			   String pattern = "{\"%s\" : %d}";
			   String json = String.format(pattern, "result", result);
			   
			   response.setContentType("application/json;charset=UTF-8");
//			   Serialization
			   PrintWriter out = response.getWriter();
			   out.print(json); //직렬화에 해당
			   
		   } else {
			   request.getRequestDispatcher("/WEB-INF/views/04/factorial2.jsp").forward(request, response); //redirection을 사용할 경우에는 클래스패스 절대경로가 필요하다.
			   //controller에서 view로 넘기기 위해 사용
		   }
	}
}
