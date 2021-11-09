package br.com.ifood.model;

public class MenuModel {

  private int menuId;
  private int restaurantId;
  private Boolean menuStatus;
  private String menuName;

  public int getMenuId() {
    return menuId;
  }

  public void setMenuId(int menuId) {
    this.menuId = menuId;
  }

  public int getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(int restaurantId) {
    this.restaurantId = restaurantId;
  }

  public Boolean getMenuStatus() {
    return menuStatus;
  }

  public void setMenuStatus(Boolean menuStatus) {
    this.menuStatus = menuStatus;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public MenuModel() {
  }
}