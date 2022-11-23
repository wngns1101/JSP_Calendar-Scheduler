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
		RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
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
		
		HttpSession session = request.getSession();
		dto.setCalName(request.getParameter("calName"));
		dto.setCalId((String)session.getAttribute("userInfoId"));
	 	dto.setCalTitle(request.getParameter("calTitle"));
	 	dto.setCalStartDate(request.getParameter("calStartDate"));
	 	dto.setCalEndDate(request.getParameter("calEndDate"));
	 	dto.setCalText(request.getParameter("calText"));
		

	 	if(dto.getCalName() == "" || dto.getCalId() == "" || dto.getCalTitle()  == "" || dto.getCalStartDate() == "" || dto.getCalEndDate() == "" || dto.getCalText() == ""){
	 		request.setAttribute("insertResult", 0);
			RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
			rd.forward(request, response);		
		}
	 	
			String str[] = dto.getCalStartDate().split("-");
			int mm = Integer.parseInt(str[1]);
			
			int result = 0;
			try {
				result = dao.calInsert(dto, mm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			if(result == -1){
				request.setAttribute("insertResult", 1);
				RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
				rd.forward(request, response);
			}else{
				request.setAttribute("insertResult", 2);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
		
		}
	}

}
