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
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet(name = "AdminLogin.do", urlPatterns = { "/AdminLogin.do" })
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String dbName = "SET2_AbhayKhurana_Db";
		// DB server name to be used in connection URL
		String serverName = "punv730f.egeng.info";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			Statement stmt = con.createStatement();

			String str = "SELECT * FROM Admin_Details";
			ResultSet rs = stmt.executeQuery(str);

			while (rs.next()) {

				String Username = rs.getString("username");
				String Password = rs.getString("password");
				if (username.equals(Username) && password.equals(Password)) {
					System.out.println("Acess Allows");
					response.sendRedirect("HomeProduct.html");

				}
				else
				{
					System.out.print("Incorect Details!!");
				}
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
