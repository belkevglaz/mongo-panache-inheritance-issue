package com.example.bo;

/**
 */
public class MilkFood implements Food {

	private Integer content;

	public MilkFood() {
	}

	public MilkFood(Integer content) {
		this.content = content;
	}

	public Integer getContent() {
		return content;
	}

	public void setContent(Integer content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MilkFood{" +
				"content=" + content +
				'}';
	}

	@Override
	public String getType() {
		return "milk";
	}
}
