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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader(request.getParameter("json")));
			JSONObject jsonObject = (JSONObject) obj;

			UserModel user = ParsefromJSON(jsonObject);
			System.out.println(user);
			
			response.setContentType(ParseToJSON(user));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	protected UserModel ParsefromJSON(JSONObject jsonObject) {
	   String login = (String)jsonObject.get("login");
	   String pwd = (String)jsonObject.get("pwd");
	
	   return new UserModel(login, pwd);
	}
	
	protected String ParseToJSON(UserModel user) {
		String json = "{login:" + user.getLogin() + ",validAuth:true,role:‘ADMIN’}";
		return json;
	}
}
