package com.fsalac.form.model.dto;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.fsalac.form.model.PosCustomer;

/**
 *
 * @author fsalac
 */
public class PosCustomerDTO extends ModelObjectDTO {
	
    private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String city;
    private String phoneNumber;
    private Long maximumCreditLine;
    private Long creditTerm;
    private Date registrationDate;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getMaximumCreditLine() {
		return maximumCreditLine;
	}
	public void setMaximumCreditLine(Long maximumCreditLine) {
		this.maximumCreditLine = maximumCreditLine;
	}
	public Long getCreditTerm() {
		return creditTerm;
	}
	public void setCreditTerm(Long creditTerm) {
		this.creditTerm = creditTerm;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public static PosCustomerDTO valueOf(PosCustomer posCustomer){
		
		PosCustomerDTO posCustomerDTO = new PosCustomerDTO();
		posCustomerDTO.setId(posCustomer.getId());
		posCustomerDTO.setFirstName(posCustomer.getFirstName());
		posCustomerDTO.setMiddleName(posCustomer.getMiddleName());
		posCustomerDTO.setLastName(posCustomer.getLastName());
		posCustomerDTO.setAddress(posCustomer.getAddress());
		posCustomerDTO.setCity(posCustomer.getCity());
		posCustomerDTO.setPhoneNumber(posCustomer.getPhoneNumber());
		posCustomerDTO.setMaximumCreditLine(posCustomer.getMaximumCreditLine());
		posCustomerDTO.setCreditTerm(posCustomer.getCreditTerm());
		posCustomerDTO.setRegistrationDate(posCustomer.getRegistrationDate());
		
		return posCustomerDTO;
	}
	
	public static List<PosCustomerDTO> valueOf(List<PosCustomer> posCustomers){
		
		List<PosCustomerDTO> posCustomersDTO = new LinkedList<PosCustomerDTO>();
		
		for (PosCustomer posCustomer : posCustomers) {
			posCustomersDTO.add(valueOf(posCustomer));
		}
		return posCustomersDTO;
	}
}