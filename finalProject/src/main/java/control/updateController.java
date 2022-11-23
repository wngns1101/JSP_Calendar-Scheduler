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
 * Servlet implementation class updateController
 */
@WebServlet("/updateController")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/signUp.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		calDTO dto = new calDTO();
		calDAO dao = new calDAO();

		String str[] = request.getParameter("calStartDate").split("-");
		int mm = Integer.parseInt(str[1]);
		
		dto.setCalOldTitle(request.getParameter("calOldTitle"));
		HttpSession session = request.getSession();
		dto.setCalId((String) session.getAttribute("userInfoId"));
		dto.setCalTitle(request.getParameter("calTitle"));
		dto.setCalStartDate(request.getParameter("calStartDate"));
		dto.setCalEndDate(request.getParameter("calEndDate"));
		dto.setCalText(request.getParameter("calText"));

		if (dto.getCalOldTitle() == null || dto.getCalId() == null || dto.getCalTitle() == null
				|| dto.getCalStartDate() == null || dto.getCalEndDate() == null || dto.getCalText() == null) {
			request.setAttribute("updateResult", 0);
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
		}

		int result = 0;
		try {
			result = dao.calUpdate(dto, mm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == -1) {
			request.setAttribute("updateResult", 1);
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("updateResult", 2);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

}
