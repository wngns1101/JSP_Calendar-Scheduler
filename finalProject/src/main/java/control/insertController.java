package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendar.calDAO;
import calendar.calDTO;

/**
 * Servlet implementation class insertController
 */
@WebServlet("/insertController")
public class insertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/signUp.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	 	calDTO dto = new calDTO();
		calDAO dao = new calDAO();
		
		String str[] = request.getParameter("calStartDate").split("-");
		int mm = Integer.parseInt(str[1]); 
		HttpSession session = request.getSession();
		String calName = request.getParameter("calName");
		String userInfoId = (String)session.getAttribute("userInfoId");
		String calTitle = request.getParameter("calTitle");
		String calStartDate = request.getParameter("calStartDate");
		String calEndDate = request.getParameter("calEndDate");
		String calText = request.getParameter("calText");

	 	if(calName.equals(null) ||userInfoId == null ||calTitle  == null || calStartDate == null || calEndDate == null ||calText == null){
	 		request.setAttribute("joinResult", 0);
			RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
			rd.forward(request, response);		
		}else{
			dto.setCalName(calName);
			dto.setCalId(userInfoId);
		 	dto.setCalTitle(calTitle);
		 	dto.setCalStartDate(calStartDate);
		 	dto.setCalEndDate(calEndDate);
		 	dto.setCalText(calText);
			int result = 0;
			try {
				result = dao.calInsert(dto, mm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			if(result == -1){
				request.setAttribute("joinResult", 1);
				RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
				rd.forward(request, response);
			}else{
				request.setAttribute("joinResult", 2);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}
	}

}
