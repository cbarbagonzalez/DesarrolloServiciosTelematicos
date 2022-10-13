package login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessLoginServlet
 */
@WebServlet("/ProcessLoginServlet")
public class ProcessLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String loginName = request.getParameter("loginName");
	    if ( (loginName == null) || (loginName.trim().length() == 0) ) {
	      Map errors = new HashMap();
	      errors.put("loginName", "Mandatory field");
	      request.setAttribute("errors", errors);
	      forwardToShowLogin(request, response);
	    } else {
	        LoginManager.login(request, loginName.trim());
	        response.sendRedirect("/Redes/MainPageServlet");
	    }
	  }
	  private void forwardToShowLogin(HttpServletRequest request, HttpServletResponse response) 
	                   throws IOException, ServletException {
	    RequestDispatcher requestDispatcher =request.getRequestDispatcher("/ShowLoginServlet");//ojo que no hay que poner el /Redes
	    requestDispatcher.forward(request, response);
	  }


}
