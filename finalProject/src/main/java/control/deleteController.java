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

/**
 * Servlet implementation class deleteController
 */
@WebServlet("/deleteController")
public class deleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		calDAO dao = new calDAO();
	
		String title = request.getParameter("calTitle");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("userInfoId");

		if(title == null || request.getParameter("calDeleteDate") == ""){
			request.setAttribute("deleteResult", 0);
			RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp");
			rd.forward(request, response);
		}else{
			String str[] = request.getParameter("calDeleteDate").split("-");
			int mm = Integer.parseInt(str[1]);
			int result = 0;
			try {
				result = dao.calDelete(id, title, mm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			if(result == -1){
				request.setAttribute("deleteResult", 1);
				RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp");
				rd.forward(request, response);
			}else if(result == 0){
				request.setAttribute("deleteResult", 2);
				RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp");
				rd.forward(request, response);
			}else{
				request.setAttribute("deleteResult", 3);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}
	}

}
