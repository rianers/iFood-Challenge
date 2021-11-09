package br.com.ifood.DAO;

import java.util.List;
import br.com.ifood.model.CategoryModel;

public interface CategoryDAO {

	public List<CategoryModel> getAll();

	public CategoryModel get(int categoryId);

	public void insert(CategoryModel category);

	public void update(CategoryModel category);

	public void remove(int categoryId);
}
