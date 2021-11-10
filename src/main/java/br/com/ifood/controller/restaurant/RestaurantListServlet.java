package br.com.ifood.controller.restaurant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.DAO.RestaurantDAO;
import br.com.ifood.DAO.RestaurantDAOImpl;


@WebServlet("/RestaurantList")
public class RestaurantListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestaurantDAO _restaurant;
	
    public RestaurantListServlet() {
        super();
        
        _restaurant = new RestaurantDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Java
		var restaurantList = _restaurant.getAll();
		
		//Web
		request.setAttribute("restaurantList", restaurantList);
		RequestDispatcher rd = request.getRequestDispatcher("nomedoArquivoJSP");
		rd.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
