package br.com.ifood.DAO;

import java.sql.*;
import java.util.*;

import br.com.ifood.model.AddressModel;
import br.com.ifood.util.DBManager;

public class AddressDAOImpl implements AddressDAO {

	private Connection connection;
	PreparedStatement pstmt = null;

	@Override
	public List<AddressModel> getAll() {

		List<AddressModel> addresses = new ArrayList<AddressModel>();

		try {

			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("SELECT * FROM address");

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				AddressModel address = new AddressModel();
				address.setAddressId(result.getInt("id"));
				address.setNeighbourhood(result.getString("neighbourhood"));

				addresses.add(address);
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
		return addresses;
	}

	@Override
	public AddressModel get(int restaurantId) {

		AddressModel address = new AddressModel();

		try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("SELECT 1 FROM address WHERE restaurantId = ?");
			pstmt.setInt(1, restaurantId);
			ResultSet result = pstmt.executeQuery();

			address.setAddressId(result.getInt("id"));
			address.setNeighbourhood(result.getString("neighbourhood"));

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
		return address;
	}

	@Override
	public void insert(AddressModel address) {
		try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("INSERT INTO address (neighbourhood) VALUES (?)");
			pstmt.setString(1, address.getNeighbourhood());
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
	public void update(AddressModel address) {
		try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("UPDATE address SET neighbourhood = ? WHERE id = ?");
			pstmt.setString(1, address.getNeighbourhood());
			pstmt.setInt(2, address.getAddressId());
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
	public void remove(int addressId) {
		try {
			connection = DBManager.getConnection();
			pstmt = connection.prepareStatement("DELETE FROM address WHERE id = ?");
			pstmt.setInt(1, addressId);
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