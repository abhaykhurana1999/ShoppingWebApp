package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Customer;

public class CustomerDao {

	String dbName = "SET2_AbhayKhurana_Db";
	// DB server name to be used in connection URL
	String serverName = "punv730f.egeng.info";
	// JDBC connection URL
	String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName=" + dbName;

	public boolean checkCustomer(Customer customer) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			Statement stmt = con.createStatement();

			String str = "SELECT * FROM Customer";
			ResultSet rs = stmt.executeQuery(str);

			while (rs.next()) {
				
				String username = rs.getString("username");
				String password = rs.getString("password");
				if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
					System.out.println("Acess Allows");
					return true;
					
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
		return false;
	}

	public boolean registerCustomer(Customer customer) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");

			String str = " INSERT INTO Customer VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(str);

			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getFirstname());
			ps.setString(4, customer.getLastname());
			ps.setString(5, customer.getPhone());
			ps.setString(6, customer.getEmail());
			ps.setString(7, customer.getBillingaddress());
			ps.setString(8, customer.getShippingaddress());
			ps.setInt(9, customer.getId());

			int count = ps.executeUpdate();
			ps.close();
			con.close();
			if (count > 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		return false;
	}

	public boolean updateCustomer(Customer customer) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");

			String str = "UPDATE Customer SET username = ?, password= ?,firstname=?,lastname=?,phone=?,email=?,billingaddress=?,shippingaddress=?  WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(str);

			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getFirstname());
			ps.setString(4, customer.getLastname());
			ps.setString(5, customer.getPhone());
			ps.setString(6, customer.getEmail());
			ps.setString(7, customer.getBillingaddress());
			ps.setString(8, customer.getShippingaddress());
			ps.setInt(9, customer.getId());

			int count = ps.executeUpdate();
			ps.close();
			con.close();
			if (count > 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		return false;
	}

	public boolean deleteCustomer(String id) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");

			String str = "DELETE FROM Customer WHERE id= ?";

			PreparedStatement ps = con.prepareStatement(str);

			ps.setString(1, id);

			int count = ps.executeUpdate();
			ps.close();
			con.close();
			if (count > 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		return false;
	}
}
