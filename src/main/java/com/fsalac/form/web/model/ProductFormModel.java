package com.fsalac.form.web.model;

public class ProductFormModel extends BaseFormModel {

	private String id;
	private String productName;
	private String supplier;
	private String color;
	private String size;
	private Double catalogPrice;
	
	//add more fields
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isNew() {
		return (this.getId() == null);
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Double getCatalogPrice() {
		return catalogPrice;
	}
	public void setCatalogPrice(Double catalogPrice) {
		this.catalogPrice = catalogPrice;
	}
}
