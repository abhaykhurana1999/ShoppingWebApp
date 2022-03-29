package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import model.Product;

/**
 * Servlet implementation class UpdateDataServlet
 */
@WebServlet("/Update.do")
public class UpdateDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String Name=request.getParameter("name");
		String Price=request.getParameter("price");
		String Units=request.getParameter("units");
		String Category=request.getParameter("category");
		ProductDao productdao=new ProductDao();
		Product product=new Product(Name,Float.parseFloat(Price),Integer.parseInt(Units),Category,Integer.parseInt(id));
		boolean flag=productdao.UpdateData(product);
		if(flag==true)
		{
			out.print("Data  Updated Sucessfully");
		}
		else
		{
			out.print("Something Fishhy Happended Check Code!!");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
