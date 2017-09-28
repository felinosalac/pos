package com.fsalac.form.web.model;

public class SupplierFormModel extends BaseFormModel {

	private String id;
	private String name;
	private String address;
	private String contactPersonName;
	private String phonePrimary;
	private String fax;
	private String discount;

	public boolean isNew() {
		return (this.getId() == null);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getPhonePrimary() {
		return phonePrimary;
	}

	public void setPhonePrimary(String phonePrimary) {
		this.phonePrimary = phonePrimary;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

}
