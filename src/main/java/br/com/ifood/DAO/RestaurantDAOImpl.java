package br.com.ifood.DAO;

import java.util.*;
import java.sql.*;

import br.com.ifood.model.RestaurantModel;
import br.com.ifood.util.DBManager;

public class RestaurantDAOImpl implements RestaurantDAO {

  private Connection connection;
  PreparedStatement pstmt = null;

  @Override
  public List<RestaurantModel> getAll() {

    List<RestaurantModel> restaurants = new ArrayList<RestaurantModel>();

  	  try {

      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT * FROM restaurant");

      ResultSet result = pstmt.executeQuery();

      while (result.next()) {
        RestaurantModel restaurant = new RestaurantModel();
        restaurant.setId(result.getInt("id"));
        restaurant.setName(result.getString("name"));
        restaurant.setCnpj(result.getString("cnpj"));
        restaurant.setCnae(result.getString("cnae"));

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
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT 1 FROM restaurant WHERE id = ?");
      pstmt.setInt(1, restaurantId);
      ResultSet result = pstmt.executeQuery();

      restaurant.setId(result.getInt("id"));
      restaurant.setName(result.getString("name"));
      restaurant.setCnpj(result.getString("cnpj"));
      restaurant.setCnae(result.getString("cnae"));
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
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("INSERT INTO restaurant (name, cnpj, cnae) VALUES (?, ?, ?)");
      pstmt.setString(1, restaurant.getName());
      pstmt.setString(2, restaurant.getCnpj());
      pstmt.setString(3, restaurant.getCnae());
      pstmt.executeUpdate();

    } catch (SQLException e) {
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

  @Override
  public void update(RestaurantModel restaurant) {
    try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("UPDATE restaurant SET name = ?, cnpj = ?, cnae = ? WHERE id = ?");
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getCnpj());
			pstmt.setString(3, restaurant.getCnae());
      pstmt.setInt(4, restaurant.getId());
			pstmt.executeUpdate();

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
  }

  @Override
  public void remove(int restaurantId) {
    try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("DELETE FROM restaurant WHERE id = ?");
			pstmt.setInt(1, restaurantId);
			pstmt.executeUpdate();
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
	}
}