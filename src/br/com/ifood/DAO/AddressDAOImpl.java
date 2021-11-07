package br.com.ifood.DAO;

import java.sql.*;
import java.util.*;

import br.com.ifood.model.AddressModel;
import br.com.ifood.util.DBConnection;

public class AddressDAOImpl implements AddressDAO {

	private Connection connection;
	PreparedStatement pstmt = null;

	@Override
	public void insert(AddressModel address) {
		try {
			connection = DBConnection.getConnection();
			pstmt = connection.prepareStatement("INSERT INTO address (id, neighbourhood) VALUES (?, ?)");
			pstmt.setInt(1, address.getAddressId());
			pstmt.setString(2, address.getNeighbourhood());
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
	public AddressModel get(int restaurantId) {

		AddressModel address = new AddressModel();

		try {
			connection = DBConnection.getConnection();
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
	public List<AddressModel> getAll() {

		List<AddressModel> addresses = new ArrayList<AddressModel>();

		try {

			connection = DBConnection.getConnection();
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
}
