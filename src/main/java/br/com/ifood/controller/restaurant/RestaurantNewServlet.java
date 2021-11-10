package br.com.ifood.controller.restaurant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.DAO.RestaurantDAO;
import br.com.ifood.DAO.RestaurantDAOImpl;
import br.com.ifood.model.RestaurantModel;


@WebServlet("/RestaurantNew")
public class RestaurantNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestaurantDAO _restaurant;
	
    public RestaurantNewServlet() {
        super();
        _restaurant = new RestaurantDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RestaurantModel rest = new RestaurantModel();
		rest.setName("Pizza Hut");
		rest.setCnae("1234-05");
		rest.setCnpj("437.0939.03-10");
		_restaurant.insert(rest);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
