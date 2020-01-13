package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

public class Login extends HttpServlet {

	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 validate(req, resp);
		 
	}
	public void validate(HttpServletRequest req, HttpServletResponse resp) {
		
		String un = req.getParameter("un");
		String pwd = req.getParameter("pwd");
		
		String dburl = "jdbc:mysql://localhost:3306/"
				+ "cred?user=root&password=root";
		String query = "select password from credentials where username = ?";
		
		try {
			PrintWriter out = resp.getWriter();
			
			  Driver driver = new com.mysql.cj.jdbc.Driver();
			  DriverManager.registerDriver(driver);
			  Connection con = DriverManager.getConnection(dburl);
			  PreparedStatement ps = con.prepareStatement(query);
			  ps.setString(1, un);
			  ResultSet rs = ps.executeQuery();
			  if (rs.next()) {
				String dbpwd = rs.getString("password");
				if (dbpwd.equals(pwd)) {
					
					out.println("<html><body></head><title>Application</title>"
							+ "</head><h1>Login Successfull</h1><br>"
							+ "</body></html>");
				}else {
					
					out.println("<html><body></head><title>Application</title>"
							+ "</head><h1>Invalid Password</h1><br>"
							+ "<a href='Login.html'>Back to Login</a></body></html>");
				}
			} else {
                
					out.println("<html><body></head><title>Application</title>"
							+ "</head><h1>Invalid Username</h1><br>"
							+ "<a href='Login.html'>Back to Login</a></body></html>");
			}
			con.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
