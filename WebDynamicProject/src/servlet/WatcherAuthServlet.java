package servlet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.UserModel;

/**
 * Servlet implementation class WatcherAuthServlet
 */
@WebServlet("/WatcherAuth")
public class WatcherAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WatcherAuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonAuth ="{"+"\"login\":\"jdoe\","+ "\"pwd\":\"jdoepwd\"}";
		
		UserModel user = ParsefromJSON(jsonAuth);
		System.out.println(user);
		response.setContentType(ParseToJSON(user));
	}
	
	protected UserModel ParsefromJSON(String jsonAuth) {
		JSONParser parser = new JSONParser();
		Object obj;
			try {
				obj = parser.parse(jsonAuth);
				JSONObject jsonObject = (JSONObject) obj;
			    String login = (String)jsonObject.get("login");
			    String pwd = (String)jsonObject.get("pwd");
			
			    return new UserModel(login, pwd);
				
	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	protected String ParseToJSON(UserModel user) {
		return "{login:" + user.getLogin() + ",validAuth:true,role:‘ADMIN’}";
	}
}
