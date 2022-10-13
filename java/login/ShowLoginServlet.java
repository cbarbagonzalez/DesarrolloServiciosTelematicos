package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowLoginServlet
 */
@WebServlet("/ShowLoginServlet")
public class ShowLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String loginName = "";
	    String loginNameErrorMessage = "";

	    /* Obtener los errores obtenidos por ProcessLoginServlet*/
	    Map errors = (Map) request.getAttribute("errors");
	    if (errors != null) {
	      String errorHeader = "<font color=\"red\"><b>";
	      String errorFooter = "</b></font>";
	      if (errors.containsKey("loginName")) {
	        loginName = request.getParameter("loginName");
	        loginNameErrorMessage = errorHeader +errors.get("loginName") + errorFooter;     
	      }
	    }
	    /* Generar respuesta. */
	    response.setContentType("text/html; charset=ISO-8859-1");
	    PrintWriter out = response.getWriter();

	    /* Inicio y cabecera HTML. */
	    out.println("<html><head><title>");out.println("Formulario de Login");out.println("</title></head>");
	    out.println("<body text=\"#000000\" bgcolor=\"#ffffff\">");

	    /* Comienzo del formulario. */
	    out.println("<form method=\"POST\" action=\"\\Redes\\ProcessLoginServlet\">");
	    /* Comienzo tabla. */
	    out.println("<table width=\"100%\" border=\"0\" align=\"center\" " +"cellspacing=\"12\">");

	    /* Login. */
	    out.println("<tr>");out.println("<th align=\"right\" width=\"50%\"> Login name </th>");
	    out.println("<td align=\"left\">" +"<input type=\"text\" name=\"loginName\" " +" value=\"" + loginName
	    + "\" size=\"16\" maxlength=\"16\">" +loginNameErrorMessage + "</td>");

	    /* Boton de Login. */
	    out.println("<tr>");out.println("<td width=\"50%\"></td>");
	    out.println("<td align=\"left\" width=\"50%\"> "
	     +"<input type=\"submit\" value=\"Login\"></td>");out.println("</tr>");
	    out.println("</table>");out.println("</body></html>");
	    out.close();
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
