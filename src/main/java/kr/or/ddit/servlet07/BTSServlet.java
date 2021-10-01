package kr.or.ddit.servlet07;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.vo.BTSVO;

@WebServlet(value="/bts.do", loadOnStartup=2) 
public class BTSServlet extends HttpServlet {

   @Override
   public void init(ServletConfig config) throws ServletException {
      super.init(config);
      Map<String, BTSVO> btsMap = new LinkedHashMap<>();
      btsMap.put("B001", new BTSVO("B001", "RM", "bts/rm"));   // 아래 prefix랑 suffix가 있어야 완전한 경로가 된다. 
      btsMap.put("B002", new BTSVO("B002", "뷔", "bts/bui"));
      btsMap.put("B003", new BTSVO("B003", "지민", "bts/jimin"));
      btsMap.put("B004", new BTSVO("B004", "제이홉", "bts/jhop"));
      btsMap.put("B005", new BTSVO("B005", "진", "bts/jin"));
      btsMap.put("B006", new BTSVO("B006", "슈가", "bts/suga"));
      btsMap.put("B007", new BTSVO("B007", "정국", "bts/jungkuk"));
      getServletContext().setAttribute("btsMap", btsMap);   // => 싱글턴 
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
//       1. 요청을 받고, 분석
       String code = req.getParameter("member");
       int sc = HttpServletResponse.SC_OK;
       String logicalviewName = null;
       if(StringUtils.isBlank(code)) {
          sc = HttpServletResponse.SC_BAD_REQUEST;
       }else {
          Map<String, BTSVO> btsMap = (Map) req.getServletContext().getAttribute("btsMap");
          if(btsMap.containsKey(code)) {
             BTSVO selected = btsMap.get(code);
//             req.setAttribute("selected", selected);
             req.getSession().setAttribute("selected", selected);
             logicalviewName = selected.getPage();
          }else {
             sc = HttpServletResponse.SC_NOT_FOUND;
          }
       }
       
       if(sc == HttpServletResponse.SC_OK) {
//       2-1. 통과
//           3-1. 모델데이터 생성
          String prefix = "/WEB-INF/views/";
          String suffix = ".jsp";
          req.getRequestDispatcher(prefix + logicalviewName + suffix).forward(req, resp);
       }else {
//       2-2. 실패 
//           3-2. 상태코드 변경 
          resp.sendError(sc);
       }
   
   } 
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      String view = "/WEB-INF/views/btsForm.jsp";
      req.getRequestDispatcher(view).forward(req, resp);
   }
   
}