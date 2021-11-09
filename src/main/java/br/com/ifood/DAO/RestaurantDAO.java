package br.com.ifood.DAO;

import java.util.List;
import br.com.ifood.model.RestaurantModel;

public interface RestaurantDAO {

	public List<RestaurantModel> getAll();

	public RestaurantModel get(int restaurantId);

	public void insert(RestaurantModel restaurant);

	public void update(RestaurantModel restaurant);

	public void remove(int restaurantId);
}