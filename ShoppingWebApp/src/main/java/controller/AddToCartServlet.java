package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import model.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addtocart.do")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
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
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();

		ProductDao productdao = new ProductDao();
		String cartid = request.getParameter("id");

		Product cartproduct = productdao.getProductById(cartid);

		ArrayList cartProducts = null;

		HttpSession session = request.getSession(true);

		cartProducts = (ArrayList) session.getAttribute("cartProducts");

		if (cartProducts == null) {
			cartProducts = new ArrayList();
			cartProducts.add(cartproduct);
			session.setAttribute("cartProducts", cartProducts);
			System.out.print(cartProducts);
		} else {

			cartProducts.add(cartproduct);
			System.out.print(cartProducts);
		}

		response.sendRedirect("ViewCart.jsp");

		// request.setAttribute("customerCartProducts", cartProducts);
		// RequestDispatcher rd = request.getRequestDispatcher("customerCart.jsp");
		// rd.forward(request, response);

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
