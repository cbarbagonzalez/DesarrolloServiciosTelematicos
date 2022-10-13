package ejemploservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Sesiones
 */
@WebServlet("/Sesiones")
public class Sesiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesiones() {
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
		String item = request.getParameter("item");
	     HttpSession session = request.getSession(true); //Para ese usuario concreto
	     if (session.isNew()) {
	        session.setAttribute(session.getId(),item);
	     }
	     else {
	       String acumulado = (String) session.getAttribute (session.getId());
	       acumulado=acumulado+" "+item;
	       session.setAttribute(session.getId(),acumulado); 
	     }  
	     PrintWriter out = response.getWriter();
	     out.println("<html><body>");
	     out.println("<form ACTION=\"/EjemploServlet/Sesiones\" METHOD=\"POST\">");
	     //Resto formulario
	     out.println("<p>Lleva comprado : <h4>");
	     out.println(session.getAttribute(session.getId())+"</h4>");
	     Date created = new Date(session.getCreationTime());
	     Date accessed = new Date(session.getLastAccessedTime());
	     out.println("<p>ID " + session.getId());
	     out.println("<br>Created: " + created);
	     out.println("<br>Last Accessed: " + accessed);

	}

}
