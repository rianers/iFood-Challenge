package br.com.ifood.DAO;

import java.util.List;
import br.com.ifood.model.MenuModel;

public interface MenuDAO {

	public List<MenuModel> getAll();

	public MenuModel get(int menuId);

	public void insert(MenuModel menu);

	public void update(MenuModel menu);

	public void remove(int menuId);
}