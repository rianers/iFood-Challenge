package br.com.ifood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifood.model.MenuModel;
import br.com.ifood.util.DBConnection;

public class MenuDAOImpl implements MenuDAO {

	private Connection connection;
	PreparedStatement pstmt = null;

	@Override
	public void insert(MenuModel menu, int idRestaurant) {
		try {
			connection = DBConnection.getConnection();
			pstmt = connection.prepareStatement("INSERT INTO menu (id, mealName, mealValue) VALUES (?, ?, ?)");
			pstmt.setInt(1, menu.getId());
			pstmt.setString(2, menu.getMealName());
			pstmt.setDouble(3, menu.getMealValue());
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

	@Override
	public List<MenuModel> getMenus(int restaurantId) {
		List<MenuModel> menus = new ArrayList<MenuModel>();

		try {

			connection = DBConnection.getConnection();
			pstmt = connection.prepareStatement("SELECT * FROM menu");

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				MenuModel menu = new MenuModel();
				menu.setId(result.getInt("id"));
				menu.setMealName(result.getString("mealName"));
				menu.setMealValue(result.getDouble("mealValue"));

				menus.add(menu);
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
		return menus;
	}

}
