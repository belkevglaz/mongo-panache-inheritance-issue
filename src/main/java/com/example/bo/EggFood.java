package com.example.bo;

public class EggFood implements Food {

	private Integer category;

	public EggFood() {
	}

	public EggFood(Integer category) {
		this.category = category;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "EggFood{" +
				"category=" + category +
				'}';
	}


	@Override
	public String getType() {
		return "egg";
	}
}
