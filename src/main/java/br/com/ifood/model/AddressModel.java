package br.com.ifood.model;

public class AddressModel extends HasTimestamps {

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
}