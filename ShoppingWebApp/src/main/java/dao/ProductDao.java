package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;

public class ProductDao {

	ArrayList<Product> productList = new ArrayList<Product>();
	ArrayList<Product> productbyid = new ArrayList<Product>();

	String dbName = "SET2_AbhayKhurana_Db";
	// DB server name to be used in connection URL
	String serverName = "punv730f.egeng.info";
	// JDBC connection URL
	String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName=" + dbName;

	public boolean InsertData(Product product) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");

			String str = " INSERT INTO Product_Data VALUES (?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(str);

			ps.setString(1, product.getName());
			ps.setFloat(2, product.getPrice());
			ps.setInt(3, product.getUnits());
			ps.setString(4, product.getCategory());

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

	public Product getProductById(String id) {

		System.out.println("fetching records...");
		Product product = new Product();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");

			String str = "SELECT * FROM Product_Data where id = ?";

			PreparedStatement ps = con.prepareStatement(str);

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String name = rs.getString("name");
				String price = rs.getString("price");
				String units = rs.getString("units");
				String category = rs.getString("category");

				product = new Product(name, Float.parseFloat(price), Integer.parseInt(units), category,
						Integer.parseInt(id));

			}
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

	public ArrayList<Product> getAllProducts() {

		System.out.println("fetching records...");
		String str = "SELECT * FROM Product_Data";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(str);

			while (rs.next()) {

				String name = rs.getString("name");
				String price = rs.getString("price");
				String units = rs.getString("units");
				String category = rs.getString("category");
				String id = rs.getString("id");
				productList.add(new Product(name, Float.parseFloat(price), Integer.parseInt(units), category,
						Integer.parseInt(id)));

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

		return productList;
	}

	public boolean DeleteData(String id) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");

			String str = "DELETE FROM Product_Data WHERE id= ?";

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

	public boolean UpdateData(Product product) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");

			String str = "UPDATE Product_Data SET name = ?, price= ?,units=?,category=? WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(str);

			ps.setString(1, product.getName());
			ps.setFloat(2, product.getPrice());
			ps.setInt(3, product.getUnits());
			ps.setString(4, product.getCategory());
			ps.setInt(5, product.getId());

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
