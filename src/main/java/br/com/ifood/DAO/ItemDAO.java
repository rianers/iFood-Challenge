package br.com.ifood.DAO;

import java.util.List;
import br.com.ifood.model.ItemModel;

public interface ItemDAO {

  public List<ItemModel> getAll();

  public ItemModel get(int itemId);

  public void insert(ItemModel item);

  public void update(ItemModel item);

  public void remove(int itemId);
}
