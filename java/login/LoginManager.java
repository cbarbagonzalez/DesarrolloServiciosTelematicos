package login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginManager {
	private final static String LOGIN_NAME_ATTRIBUTE ="loginName";

	   private LoginManager() {}
	   public final static void login(HttpServletRequest request,String loginName) {
	      HttpSession session = request.getSession(true); // Crea una sesion nueva
	      
	      session.setAttribute(LOGIN_NAME_ATTRIBUTE, loginName); //ej: loginName=“juan”
	    }
	   public final static void logout(HttpServletRequest request) {
	      HttpSession session = request.getSession(false); 
	      if (session != null) {
	         session.invalidate(); //Destruye la sesion actual
	      }
	   }
	   public final static String getLoginName(HttpServletRequest request) {
	     HttpSession session = request.getSession(false);
	     if (session == null) {
	        return null;
	     } else {
	     
	     return (String) session. getAttribute(LOGIN_NAME_ATTRIBUTE);
	     }
	   }


}
