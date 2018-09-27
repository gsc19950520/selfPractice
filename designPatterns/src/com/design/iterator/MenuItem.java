package com.design.iterator;

public class MenuItem {

	private String name;
	private double cost;
	private boolean isVegetable;
	private String description;
	
	
	public MenuItem(String name, double cost, boolean isVegetable, String description) {
		this.name = name;
		this.cost = cost;
		this.isVegetable = isVegetable;
		this.description = description;
	}
	
	
	public boolean isVegetable() {
		return isVegetable;
	}


	public void setVegetable(boolean isVegetable) {
		this.isVegetable = isVegetable;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", cost=" + cost + ", isVegetable=" + isVegetable + ", description="
				+ description + "]";
	}
}
