package br.com.ifood.DAO;

import java.util.List;

import br.com.ifood.model.AddressModel;

public interface AddressDAO {

	public void insert(AddressModel address);

	public AddressModel get(int restaurantId);

	public List<AddressModel> getAll();

}
