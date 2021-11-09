package br.com.ifood.DAO;

import java.util.*;
import java.sql.*;

import br.com.ifood.model.MenuModel;
import br.com.ifood.util.DBManager;

public class MenuDAOImpl implements MenuDAO {

	private Connection connection;
	PreparedStatement pstmt = null;

	@Override
	public void insert(MenuModel menu) {
		try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("INSERT INTO menu (restaurantId, menuStatus, menuName) VALUES (?, ?, ?)");
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setBoolean(2, menu.getMenuStatus());
			pstmt.setString(3, menu.getMenuName());
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
	public List<MenuModel> getAll() {
		List<MenuModel> menus = new ArrayList<MenuModel>();

		try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("SELECT * FROM menu");

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				MenuModel menu = new MenuModel();
				menu.setMenuId(result.getInt("id"));
				menu.setRestaurantId(result.getInt("restaurantId"));
				menu.setMenuStatus(result.getBoolean("menuStatus"));
				menu.setMenuName(result.getString("menuName"));

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

	@Override
	public MenuModel get(int menuId) {
		MenuModel menu = new MenuModel();

    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT FROM menu WHERE id = ?");
      pstmt.setInt(1, menuId);
      ResultSet result = pstmt.executeQuery();

      menu.setMenuId(result.getInt("id"));
      menu.setRestaurantId(result.getInt("restaurantId"));
      menu.setMenuStatus(result.getBoolean("menuStatus"));
      menu.setMenuName(result.getString("menuName"));
	  
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
    return menu;
	}

	@Override
	public void update(MenuModel menu) {
		try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("UPDATE menu SET restaurantId = ?, menuStatus = ?, menuName = ? WHERE id = ?");
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setBoolean(2, menu.getMenuStatus());
			pstmt.setString(3, menu.getMenuName());
      		pstmt.setInt(4, menu.getMenuId());
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
	public void remove(int menuId) {
		try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("DELETE FROM menu WHERE id = ?");
			pstmt.setInt(1, menuId);
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