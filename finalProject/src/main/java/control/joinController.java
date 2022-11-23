package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.userDAO;
import user.userDTO;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class joinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public joinController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/join.jsp");
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
		userDTO user = new userDTO();
		userDAO dao = new userDAO();

		user.setId(request.getParameter("joinId"));
		user.setPassword(request.getParameter("joinPw"));
		user.setName(request.getParameter("joinName"));
		user.setGender(request.getParameter("joinGender"));
		user.setEmail(request.getParameter("joinEmail"));

		if (user.getId() == null || user.getPassword() == null || user.getName() == null || user.getGender() == null
				|| user.getEmail() == null) {
			request.setAttribute("joinResult", 0);
			RequestDispatcher rd = request.getRequestDispatcher("/join.jsp");
			rd.forward(request, response);
		}
		int check = 0;
		try {
			check = dao.joinCheck(user.getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (check == 1) {
			request.setAttribute("joinResult", 2);
			RequestDispatcher rd = request.getRequestDispatcher("/join.jsp");
			rd.forward(request, response);
		}else if(check == 0) {
			int result = 0;
			try {
				result = dao.join(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (result == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("userInfoId", user.getId());
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("joinResult", 1);
				RequestDispatcher rd = request.getRequestDispatcher("/join.jsp");
				rd.forward(request, response);
			}
		}
	}
}
