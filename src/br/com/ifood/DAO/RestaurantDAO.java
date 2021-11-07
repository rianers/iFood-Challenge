package br.com.ifood.DAO;

import br.com.ifood.model.RestaurantModel;
import java.util.*;

public interface RestaurantDAO {

	public List<RestaurantModel> getAll();

	public RestaurantModel get(int restaurantId);
	
	public void insert(RestaurantModel restaurant);

}
