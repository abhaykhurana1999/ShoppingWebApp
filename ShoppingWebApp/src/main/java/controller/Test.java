package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String dbName = "SET2_AbhayKhurana_Db";
		// DB server name to be used in connection URL
		String serverName = "punv730f.egeng.info";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName=" + dbName;
		System.out.println("fetching records...");
		String str="SELECT * FROM Student1";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery(str);

			System.out.println("Student id\tFirstName\tLast Name\tAge");
						
			while (rs.next())
			{
			String id=rs.getString("id");
			String fname=rs.getString("firstname");
			String lname=rs.getString("lastname");
			String age=rs.getString("age");
						
							
			if (id.length() <=7) 
			System.out.print(id+"\t\t");
			else 
			System.out.print(id+"\t");
			if (fname.length() <=7) 
			System.out.print(fname+"\t\t");
			else 
			System.out.print(fname+"\t");
			if (lname.length() <=7)
			System.out.print(lname+"\t\t");
			else 
			System.out.print(lname+"\t");
			System.out.println(age);				
			}
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		System.out.println("end of the table...");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
