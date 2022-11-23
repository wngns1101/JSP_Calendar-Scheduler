package control;

import java.io.IOException;

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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/signUp.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		calDAO dao = new calDAO();
		
		String str[] = request.getParameter("calDeleteDate").split("-");
		int mm = Integer.parseInt(str[1]);
	
		String title = request.getParameter("calTitle");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("userInfoId");
	
		if(title == null){
			out.println("<script>");
			out.println("alert('제목을 입력하지 않으셨습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else{
			int result = dao.calDelete(id, title, mm);	
			if(result == -1){
				out.println("<script>");
				out.println("alert('삭제에 실패했습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}else if(result == 0){
				out.println("<script>");
				out.println("alert('삭제할 일정이 없습니다.')");
				out.println("location.href='index.jsp'");
				out.println("</script>");
			}else{
				out.println("<script>");
				out.println("alert('삭제에 성공했습니다.')");
				out.println("location.href='index.jsp'");
				out.println("</script>");
			}
		}
	}

}
