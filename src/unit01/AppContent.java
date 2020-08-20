package unit01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppContent
 */
@WebServlet("/AppContent")
public class AppContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		doGet(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		
		String resourcePath = application.getInitParameter("noticePath");
		String str = "";
		URL url = application.getResource(resourcePath);
		
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(url.openStream()
						/* application.getResourceAsStream(resourcePath) */))){
			
				while((str=br.readLine()) != null){
					System.out.print(str);
				}
		}catch(IOException e){
			System.out.println("예외 발생" + e.getMessage());
		}
	
	
	
	
	
	}

}
