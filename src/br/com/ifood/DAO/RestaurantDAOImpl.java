package br.com.ifood.DAO;

import java.util.*;
import java.sql.*;

import br.com.ifood.model.AddressModel;
import br.com.ifood.model.RestaurantModel;
import br.com.ifood.util.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {

	private Connection connection;
	PreparedStatement pstmt = null;

	@Override
	public List<RestaurantModel> getAll() {

		List<RestaurantModel> restaurants = new ArrayList<RestaurantModel>();

		try {

			connection = DBConnection.getConnection();
			pstmt = connection.prepareStatement("SELECT * FROM restaurant");

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				RestaurantModel restaurant = new RestaurantModel();
				restaurant.setId(result.getInt("id"));
				restaurant.setName(result.getString("name"));

				restaurants.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return restaurants;
	}

	@Override
	public RestaurantModel get(int restaurantId) {

		RestaurantModel restaurant = new RestaurantModel();

		try {
			connection = DBConnection.getConnection();
			pstmt = connection.prepareStatement("SELECT 1 FROM restaurant WHERE id = ?");
			pstmt.setInt(1, restaurantId);
			ResultSet result = pstmt.executeQuery();

			restaurant.setId(result.getInt("id"));
			restaurant.setName(result.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return restaurant;
	}

	@Override
	public void insert(RestaurantModel restaurant) {
		try {
			connection = DBConnection.getConnection();
			pstmt = connection.prepareStatement("INSERT INTO restaurant (id, name) VALUES (?, ?)");
			pstmt.setInt(1, restaurant.getId());
			pstmt.setString(2, restaurant.getName());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
