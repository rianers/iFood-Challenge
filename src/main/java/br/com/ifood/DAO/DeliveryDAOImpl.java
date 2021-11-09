package br.com.ifood.DAO;

import java.util.*;
import java.sql.*;

import br.com.ifood.model.DeliveryModel;
import br.com.ifood.util.DBManager;

public class DeliveryDAOImpl implements DeliveryDAO {

  private Connection connection;
  PreparedStatement pstmt = null;

  @Override
  public List<DeliveryModel> getAll() {

    List<DeliveryModel> deliveries = new ArrayList<DeliveryModel>();

    try {

      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT * FROM delivery");

      ResultSet result = pstmt.executeQuery();

      while (result.next()) {
        DeliveryModel delivery = new DeliveryModel();
        delivery.setId(result.getInt("id"));
        delivery.setNeighborhoodId(result.getInt("neighbourhoodId"));
        delivery.setRestaurantId(result.getInt("restaurantId"));

        deliveries.add(delivery);
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
    return deliveries;
  }

  @Override
  public DeliveryModel get(int deliveryId) {

    DeliveryModel delivery = new DeliveryModel();

    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT 1 FROM delivery WHERE id = ?");
      pstmt.setInt(1, deliveryId);
      ResultSet result = pstmt.executeQuery();

      delivery.setId(result.getInt("id"));
      delivery.setRestaurantId(result.getInt("restaurantId"));
      delivery.setNeighborhoodId(result.getInt("neighbourhoodId"));
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
    return delivery;
  }

  @Override
  public void insert(DeliveryModel delivery) {
    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("INSERT INTO delivery (restaurantId, neighbourhoodId) VALUES (?, ?)");
      pstmt.setInt(1, delivery.getRestaurantId());
      pstmt.setInt(2, delivery.getNeighborhoodId());
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
  public void update(DeliveryModel delivery) {
    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("UPDATE delivery SET restaurantId = ?, neighbourhoodId = ? WHERE id = ?");
      pstmt.setInt(1, delivery.getRestaurantId());
      pstmt.setInt(2, delivery.getNeighborhoodId());
      pstmt.setInt(3, delivery.getId());
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
  public void remove(int deliveryId) {
    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("DELETE FROM delivery WHERE id = ?");
      pstmt.setInt(1, deliveryId);
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