package br.com.ifood.model;

public class DeliveryModel extends HasTimestamps {
  public int id;
  public int restaurantId;
  public int neighborhoodId;

  public DeliveryModel() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(int restaurantId) {
    this.restaurantId = restaurantId;
  }

  public int getNeighborhoodId() {
    return neighborhoodId;
  }

  public void setNeighborhoodId(int neighborhoodId) {
    this.neighborhoodId = neighborhoodId;
  }

  @Override
  public String toString() {
    return "DeliveryModel{id=" + id + ", restaurantId=" + restaurantId + ", neighborhoodId=" + neighborhoodId + '}';
  }
}