package br.com.ifood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifood.model.ItemModel;
import br.com.ifood.util.DBManager;

public class ItemDAOimpl implements ItemDAO {
  private Connection connection;
  PreparedStatement pstmt = null;

  @Override
  public List<ItemModel> getAll() {

    List<ItemModel> itens = new ArrayList<ItemModel>();

    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT * FROM T_ITEM");

      ResultSet result = pstmt.executeQuery();
      while (result.next()) {
        ItemModel item = new ItemModel();
        item.setItemId(result.getInt("id"));
        item.setName(result.getString("name"));
        item.setDescription(result.getString("description"));
        item.setCategoryId(result.getInt("category_id"));
        itens.add(item);
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

    return itens;
  }

  @Override
  public ItemModel get(int itemId) {
    ItemModel item = new ItemModel();

    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT * FROM T_ITEM WHERE ID = ?");
      pstmt.setInt(1, itemId);

      ResultSet result = pstmt.executeQuery();

      if (result.next()) {
        item.setItemId(result.getInt("id"));
        item.setName(result.getString("name"));
        item.setCategoryId(result.getInt("category_id"));
        item.setDescription(result.getString("description"));
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
    return item;
  }

  @Override
  public void insert(ItemModel item) {
    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("INSERT INTO T_ITEM (name, description, category_id) VALUES (?, ?, ?)");
      pstmt.setString(1, item.getName());
      pstmt.setString(2, item.getDescription());
      pstmt.setInt(3, item.getCategoryId());

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
  public void update(ItemModel item) {
    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("UPDATE T_ITEM SET name = ?, description = ?, category_id = ? WHERE id = ?");
      pstmt.setString(1, item.getName());
      pstmt.setString(2, item.getDescription());
      pstmt.setInt(3, item.getCategoryId());
      pstmt.setInt(4, item.getItemId());

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
  public void remove(int itemId) {
    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("DELETE FROM T_ITEM WHERE id = ?");
      pstmt.setInt(1, itemId);

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