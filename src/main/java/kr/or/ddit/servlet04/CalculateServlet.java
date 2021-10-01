//package kr.or.ddit.servlet04;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import kr.or.ddit.vo.BiOperandVO;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@WebServlet("/calculate.do")
//public class CalculateServlet extends HttpServlet{
//	//leftOp, rightOp, operator
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String view = "/WEB-INF/views/04/calculate.jsp";
//		req.getRequestDispatcher("/WEB-INF/views/04/calculate.jsp").forward(req, resp);//jsp로 연결될 수 있게.
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//연산 결과를 돌려주는 것
//		String accept = req.getHeader("Accept");
//		String contentType = req.getHeader("Content-Type");
//		BiOperandVO operandVO = null;
//		String message = null;
//		int sc = 200;
//		if(contentType.contains("json")) {
//			//json형태
//			try(
//					InputStream is = req.getInputStream(); //스트림 is에 요청한 값의 데이터를 읽어와 넣는다.
//				){
//					ObjectMapper objectMapper = new ObjectMapper(); // ObjectMapper를 이용한 객체 생성
//					operandVO = objectMapper.readValue(is, BiOperandVO.class); // objectMapper 객체에 testVO에 들어간 데이터들을 불러와 리턴값에 넣는다.
//				} catch(Exception e) {
//					sc = 500;
//					message = e.getMessage();
//				}
//			} else {
//			//파라미터로 넘겨 받을 때 실행
//			String leftParam = req.getParameter("leftOp");
//			String rightParam = req.getParameter("rightOp");
//			String opParam = req.getParameter("operator");
//			
//			double leftOp = -1;
//			double rightOp = -1;
//			String expression = null;
//			
//			try {
//				leftOp = Double.parseDouble(leftParam);
//				rightOp = Double.parseDouble(rightParam);
//				
//				OperatorType operator = OperatorType.valueOf(opParam);//연산에 관한 모든것이 들어가진다.
//				operandVO = new BiOperandVO();
//				operandVO.setLeftOp(leftOp);
//				operandVO.setRightOp(rightOp);
//				operandVO.setOperator(operator);
////				expression = operator.makeExpression(leftOp, rightOp);
//			} catch(Exception e) {
//				sc = 400;
//				message = e.getMessage();
//			}
//		}
//		
//		/*if("PLUS".equals(opParam)) {
//			result = leftOp + rightOp;
//			opSign = "+";
//		} else if ("MINUS".equals(opParam)) {
//			result = leftOp - rightOp; //연산구조가 1:1 형식의 매핑구조로 되어있다.
//			opSign = "-";
//		} else {
//			sc = 400;
//		}*/
//		
//		
//		
//		if(sc == 200) {
////			Map<String, Object> jsonTarget = new HashMap<>();
////			jsonTarget.put("expression", expression);
////			jsonTarget.put("leftOp", leftOp);
////			jsonTarget.put("rightOp", rightOp);
//			
//			if(accept.contains("json")) {
////				//Marshalling ======================================================================
////				String jsonPattern = "{ \"%s\" : \"%s\" , "; //객체를 만듦
////				StringBuffer json = new StringBuffer("{");
////				for(Entry<String, Object> entry : jsonTarget.entrySet()) { //put 3개를 건드린다. 1번째 put이 jsonPattern %s에 들어감
////					String propName = entry.getKey();
////					String propValue = Objects.toString(entry.getValue(), "");
////					json.append(String.format(jsonPattern, propName, propValue));
////				}
////				int lastIndex = json.lastIndexOf(",");
////				if(lastIndex != -1)
////					json.deleteCharAt(lastIndex);
////				json.append("}");
//				ObjectMapper objectMapper = new ObjectMapper();
////				String json = objectMapper.writeValueAsString(jsonTarget); //마샬링만 하기 위한 코드
//				//Serialization ====================================================================
////				String json = String.format(jsonPattern, "expression", expression); // -> 마샬링 작업
//				resp.setContentType("application/json;charset=UTF-8");
//				try(
//					PrintWriter out = resp.getWriter();
//				){	
////					out.print(json);
//					objectMapper.writeValue(out, operandVO); //마샬링, 직렬화가 이것으로 끝
//					
//				}
//			} else {
//				req.setAttribute("operandVO", operandVO);//서버에서 관리하기 때문에 직접적인 전역변수를 생성할 수 없다.
//				String view = "/WEB-INF/views/04/calculate.jsp";
//				req.getRequestDispatcher(view).forward(req, resp);//jsp로 연결될 수 있게.
//			}
//		} else {
//			resp.sendError(sc, message);
//		}
//	}
//}
