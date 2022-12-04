package ejemploservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookies  
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookies() {
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
		   response.setContentType("text/html");
		   String item=request.getParameter("item");
		   Cookie[] cookies = request.getCookies();
		   Cookie  cookie = null;
		   int i=0;
		   if (cookies == null)  {
		            cookie = new Cookie("Cesta", item);
		            cookie.setMaxAge(120);
		    }  else {
		           while ((i<cookies.length) && !(cookies[i].getName().equals("Cesta")))   i++;
		           if (cookies[i].getName().equals("Cesta")) {
		              cookie = cookies[i];
		              item = cookie.getValue()+" "+item;
		              cookie.setValue(item);
		             }
		         }
		        response.addCookie(cookie);
		        PrintWriter out = response.getWriter();
		        out.println("<html>");
		        out.println("<body bgcolor=\"white\">");   
		       // Resto formulario de respuesta
		        Enumeration<String> parameterNames = request.getParameterNames();
				 
		        while (parameterNames.hasMoreElements()) {
		 
		            String paramName = parameterNames.nextElement();
		            out.println("<p>"+paramName+"</p>"); 
		           
		            String[] paramValues = request.getParameterValues(paramName);
		            for (int j = 0; j < paramValues.length; j++) {
		                String paramValue = paramValues[j];
		                out.println(paramValue); 
		            }
		 
		        }
		        out.println("</body>"); 
		        out.println("</html>"); 

	}

}
