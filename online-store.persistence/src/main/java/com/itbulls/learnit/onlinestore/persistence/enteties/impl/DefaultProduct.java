package com.itbulls.learnit.onlinestore.persistence.enteties.impl;

import com.itbulls.learnit.onlinestore.persistence.enteties.Product;

public class DefaultProduct implements Product {

	private int id;
	private String productName;
	private String categoryName;
	private double price;
	private String productType;
	private String imgName;
	private String description;
	private String guid;

	public DefaultProduct() {
	}

	public DefaultProduct(int id, String productName, String categoryName, double price, String productType) {
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Product id=" + id + ", product name=" + productName
				+ ", category name=" + categoryName + ", price=" + price;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	@Override
	public String getCategoryName() {
		return this.categoryName;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String getProductType() {
		// TODO Auto-generated method stub
		return this.productType;
	}

	@Override
	public void setProductType(String productType) {
		// TODO Auto-generated method stub
		this.productType = productType;
	}

	@Override
	public void setImgName(String imgName) {
		// TODO Auto-generated method stub
		this.imgName = imgName;
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;
	}

	@Override
	public String getImgName() {
		// TODO Auto-generated method stub
		return this.imgName;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String getGuid() {
		return this.guid;
	}

}
