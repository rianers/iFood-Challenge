package br.com.ifood.DAO;

import java.util.List;

import br.com.ifood.model.AddressModel;

public interface AddressDAO {

	public List<AddressModel> getAll();

	public AddressModel get(int addressId);

	public void insert(AddressModel address);

	public void update(AddressModel address);

	public void remove(int addressId);
}