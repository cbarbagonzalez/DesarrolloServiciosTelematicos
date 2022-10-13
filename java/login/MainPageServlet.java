package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/MainPageServlet")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String loginName = LoginManager.getLoginName(request);
	    if (loginName != null) { // El usuario ya se ha autenticado
	      generateMainPage(response, loginName);
	    } else { // El usuario no se ha autenticado aun
	         response.sendRedirect("/Redes/ShowLoginServlet");
	    }

	}
	private void generateMainPage(HttpServletResponse response,String loginName) throws IOException {
	    response.setContentType("text/html; charset=ISO-8859-1");
	    PrintWriter out = response.getWriter();
	    out.println("<html><head><title>");
	    out.println("Pagina Principal");
	    out.println("</title></head>");
	    out.println("<body text=\"#000000\" bgcolor=\"#ffffff\" " +
	            "link=\"#000ee0\" vlink=\"#551a8b\" alink=\"#000ee0\">");
	    out.println("<h1>Hello " + loginName + "! </h1>");out.println("<br><br><br>");
	    out.println("<a href=\"http://www.lcc.uma.es\">Departamento LCC " +"Inicio</a><br>");
	    out.println("<a href=\"/Redes/ProcessLogoutServlet\">Logout</a><br>");
	    out.println("</body></html>");out.close();
	  }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
