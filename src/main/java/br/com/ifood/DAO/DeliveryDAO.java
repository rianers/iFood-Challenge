package br.com.ifood.DAO;

import java.util.List;
import br.com.ifood.model.DeliveryModel;

public interface DeliveryDAO {

  public List<DeliveryModel> getAll();

  public DeliveryModel get(int deliveryId);

  public void insert(DeliveryModel delivery);

  public void update(DeliveryModel delivery);

  public void remove(int deliveryId);
}