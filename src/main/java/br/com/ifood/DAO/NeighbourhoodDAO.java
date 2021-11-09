package br.com.ifood.DAO;

import java.util.List;
import br.com.ifood.model.NeighbourhoodModel;

public interface NeighbourhoodDAO {

	public List<NeighbourhoodModel> getAll();

	public NeighbourhoodModel get(int neighbourhoodId);

	public void insert(NeighbourhoodModel neighbourhood);

	public void update(NeighbourhoodModel neighbourhood);

	public void remove(int restaurantId);
}
