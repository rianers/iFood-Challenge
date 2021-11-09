package br.com.ifood.DAO;

import java.sql.*;
import java.util.*;

import br.com.ifood.model.CategoryModel;
import br.com.ifood.util.DBManager;

public class CategoryDAOImpl implements CategoryDAO {

  private Connection connection;
  PreparedStatement pstmt = null;

  @Override
  public List<CategoryModel> getAll() {
    List<CategoryModel> categories = new ArrayList<CategoryModel>();

    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT * FROM category");
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        CategoryModel category = new CategoryModel();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        category.setImage(rs.getString("image"));
        categories.add(category);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return categories;
  }

  @Override
  public CategoryModel get(int categoryId) {
    CategoryModel category = new CategoryModel();

    try {
        connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT * FROM category WHERE id = ?");
      pstmt.setInt(1, categoryId);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        category.setImage(rs.getString("image"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return category;
  }

  @Override
  public void insert(CategoryModel category) {
    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("INSERT INTO category (name, image) VALUES (?, ?)");
      pstmt.setString(1, category.getName());
      pstmt.setString(2, category.getImage());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void update(CategoryModel category) {
    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("UPDATE category SET name = ?, image = ? WHERE id = ?");
      pstmt.setString(1, category.getName());
      pstmt.setString(2, category.getImage());
      pstmt.setInt(3, category.getId());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void remove(int categoryId) {
    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("DELETE FROM category WHERE id = ?");
      pstmt.setInt(1, categoryId);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
