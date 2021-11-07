package br.com.ifood.model;

public class AddressModel {

	private int addressId;
	private String neighbourhood;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public AddressModel() {

	}

	public AddressModel(int addressId, String neighbourhood) {
		this.addressId = addressId;
		this.neighbourhood = neighbourhood;
	}

}
