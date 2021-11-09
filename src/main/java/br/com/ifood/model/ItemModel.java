package br.com.ifood.model;

public class ItemModel {

  private int itemId;
  private int categoryId;
  private String name;
  private String description;

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ItemModel() {

  }
}
