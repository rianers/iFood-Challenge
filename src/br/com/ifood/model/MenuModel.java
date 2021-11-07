package br.com.ifood.model;

public class MenuModel {

	private int id;
	private String mealName;
	private double mealValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public double getMealValue() {
		return mealValue;
	}

	public void setMealValue(double mealValue) {
		this.mealValue = mealValue;
	}

	public MenuModel() {

	}

	public MenuModel(int idCardapio, String mealName, double mealValue) {
		this.id = idCardapio;
		this.mealName = mealName;
		this.mealValue = mealValue;
	}

	public double averageValue(double mealValueTotal, int mealQuantity) {
		return mealValueTotal / mealQuantity;
	}

}
