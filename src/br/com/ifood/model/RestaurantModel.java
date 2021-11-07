package br.com.ifood.model;

public class RestaurantModel {

	private int restaurantId;
	private String restaurantName;

	public int getId() {
		return restaurantId;
	}

	public void setId(int id) {
		restaurantId = id;
	}

	public String getName() {
		return restaurantName;
	}

	public void setName(String name) {
		restaurantName = name;
	}

	public RestaurantModel(int restaurantId, String restaurantName) {
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
	}

	public RestaurantModel() {

	}

}
