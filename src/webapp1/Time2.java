package webapp1;

import java.io.IOException;           
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Time2 extends HttpServlet {	
	
	  @Override
	protected void doGet
	(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		  PrintWriter out = resp.getWriter();
		  
		  resp.setContentType(".jpeg");
		  resp.setContentLength(500);
		  
		  resp.sendError(500, "Resource not found");
		  
		 
	}
	
}
