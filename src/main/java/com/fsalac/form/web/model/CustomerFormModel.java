package com.fsalac.form.web.model;

public class CustomerFormModel extends BaseFormModel {

	private String id;
	private String name;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String maximumCreditLine;
	private String creditTerm;
	private String registrationDate;
	private byte[] profilePicture;
	private byte[] signature;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMaximumCreditLine() {
		return maximumCreditLine;
	}

	public void setMaximumCreditLine(String maximumCreditLine) {
		this.maximumCreditLine = maximumCreditLine;
	}

	public String getCreditTerm() {
		return creditTerm;
	}

	public void setCreditTerm(String creditTerm) {
		this.creditTerm = creditTerm;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

}
