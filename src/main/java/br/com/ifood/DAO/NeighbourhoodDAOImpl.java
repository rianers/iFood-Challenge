package br.com.ifood.DAO;

import java.util.*;
import java.sql.*;

import br.com.ifood.model.NeighbourhoodModel;
import br.com.ifood.util.DBManager;

public class NeighbourhoodDAOImpl implements NeighbourhoodDAO {

  private Connection connection;
  PreparedStatement pstmt = null;

  @Override
  public List<NeighbourhoodModel> getAll() {

    List<NeighbourhoodModel> neighbourhoods = new ArrayList<NeighbourhoodModel>();

    try {

      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT * FROM neighbourhood");

      ResultSet result = pstmt.executeQuery();

      while (result.next()) {
        NeighbourhoodModel neighbourhood = new NeighbourhoodModel();
        neighbourhood.setId(result.getInt("id"));
        neighbourhood.setName(result.getString("name"));

        neighbourhoods.add(neighbourhood);
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
    return neighbourhoods;
  }

  @Override
  public NeighbourhoodModel get(int neighbourhoodId) {

    NeighbourhoodModel neighbourhood = new NeighbourhoodModel();

    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("SELECT 1 FROM neighbourhood WHERE id = ?");
      pstmt.setInt(1, neighbourhoodId);
      ResultSet result = pstmt.executeQuery();

      neighbourhood.setId(result.getInt("id"));
      neighbourhood.setName(result.getString("name"));
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
    return neighbourhood;
  }

  @Override
  public void insert(NeighbourhoodModel neighbourhood) {
    try {
      connection = DBManager.getConnection();
      pstmt = connection.prepareStatement("INSERT INTO neighbourhood (name) VALUES (?)");
      pstmt.setString(1, neighbourhood.getName());
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
  public void update(NeighbourhoodModel neighbourhood) {
    try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("UPDATE neighbourhood SET name = ? WHERE id = ?");
			pstmt.setString(1, neighbourhood.getName());
            pstmt.setInt(2, neighbourhood.getId());
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
  public void remove(int neighbourhoodId) {
    try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("DELETE FROM neighbourhood WHERE id = ?");
			pstmt.setInt(1, neighbourhoodId);
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