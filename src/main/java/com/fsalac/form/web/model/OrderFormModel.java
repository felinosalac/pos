package com.fsalac.form.web.model;

public class OrderFormModel extends BaseFormModel {

	private String id;
	private String customer;
	private String product;
	
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
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
}
