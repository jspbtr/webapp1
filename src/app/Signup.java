package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

public class Signup extends HttpServlet {

	 
	@Override
	protected void doPost(HttpServletRequest req, 
HttpServletResponse resp) throws ServletException, IOException {
		
       insert(req,resp);
		
	}
	public void insert(HttpServletRequest req,HttpServletResponse resp) {
		String dburl = "jdbc:mysql://localhost:3306/"
				+ "cred?user=root&password=root";
		String query = "insert into credentials values(?,?,?)";
		try {
			PrintWriter out = resp.getWriter();
			String un = req.getParameter("un");
			String pwd = req.getParameter("pwd");
			String em = req.getParameter("em");
			
			  Driver driver = new com.mysql.cj.jdbc.Driver();
			  DriverManager.registerDriver(driver);
			  Connection con = DriverManager.getConnection(dburl);
			  PreparedStatement ps = con.prepareStatement(query);
			  ps.setString(1, un);
			  ps.setString(2, pwd);
			  ps.setString(3, em);
			  int eu = ps.executeUpdate();
			  if (eu==1) {
				out.println("<html><body></head><title>Application</title>"
						+ "</head><h1>Account Successfully created</h1><br>"
						+ "</body></html>");
			} else {
                out.println("<html><body></head><title>Application</title>"
						+ "</head><h1>Account Creation Unsuccessfull</h1><br>"
						+ "</body></html>");
			}
			con.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	  
}
