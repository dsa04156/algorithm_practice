package com.ssafy.sample.dto;

public class ProductDTO {
	private String code;
	private String model;
	private int price;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductDTO [code=" + code + ", model=" + model + ", price=" + price + "]";
	}
	
	
}
