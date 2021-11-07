package br.com.ifood.DAO;

import java.util.List;

import br.com.ifood.model.MenuModel;

public interface MenuDAO {

	public void insert(MenuModel menu, int idRestaurant);

	public List<MenuModel> getMenus(int restaurantId);

}
