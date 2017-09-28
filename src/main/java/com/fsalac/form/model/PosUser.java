package com.fsalac.form.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "pos_users")
public class PosUser extends ModelObject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;
	
	@Basic(optional = false)
	@Column(name = "password")
	private String password;

	@Basic(optional = false)
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Basic(optional = false)
	@Column(name = "last_name")
	private String lastName;

	@Basic(optional = false)
	@Column(name = "gender")
	private String gender;

	@Basic(optional = false)
	@Column(name = "address_1")
	private String address1;

	@Column(name = "address_2")
	private String address2;

	@Basic(optional = false)
	@Column(name = "city")
	private String city;

	@Basic(optional = false)
	@Column(name = "status")
	private String status;

	@Basic(optional = false)
	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Basic(optional = false)
	@Column(name = "date_updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;

	@Column(name = "date_deleted")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDeleted;

	@Column(name = "deleted", columnDefinition = "BIT", length = 1)
	private boolean deleted;

	@Column(name = "need_update", columnDefinition = "BIT", length = 1)
	private boolean needUpdate;

	@Column(name = "active", columnDefinition = "BIT", length = 1)
	private boolean active;

	@Column(name = "updated_by")
	private Long updatedBy;

	@Column(name = "deleted_by")
	private Long deletedBy;

	@Column(name = "created_by")
	private Long createdBy;

	@Lob
	@Column(name = "picture",columnDefinition="LONGBLOB")
	private byte[] picture;

	@Lob
	@Column(name = "signature",columnDefinition="LONGBLOB")
	private byte[] signature;

	@Column(name = "address_id")
	private Long addressId;
	
	@Column(name = "email")
	private String email;
	
	
	@OneToMany(mappedBy = "userOwner", fetch = FetchType.LAZY)
	private List<PosFile> posFilesList;
	 
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserRole> userRolesList;

	@OneToMany( mappedBy = "createdBy" , fetch = FetchType.LAZY)
    private List<PosCustomer> posCustomersList;
	
	@OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<PosSupplier> posSuppliersList;
	
	
	@Transient
	private List<String> userRoles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isNeedUpdate() {
		return needUpdate;
	}

	public void setNeedUpdate(boolean needUpdate) {
		this.needUpdate = needUpdate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

//	public String getSsoId() {
//		return ssoId;
//	}
//
//	public void setSsoId(String ssoId) {
//		this.ssoId = ssoId;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isNew() {
		return (this.id == null);
	}
	
	@Column
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	@Transient
	private String name;
	
	public void setName(String name){
		this.name =  name;
	}
	
	public String getName(){
		return replaceNull(this.firstName) + " " + replaceNull(this.lastName);
	}

	public List<PosCustomer> getPosCustomersList() {
		return posCustomersList;
	}

	public void setPosCustomersList(List<PosCustomer> posCustomersList) {
		this.posCustomersList = posCustomersList;
	}

	public List<UserRole> getUserRolesList() {
		return userRolesList;
	}

	public void setUserRolesList(List<UserRole> userRolesList) {
		this.userRolesList = userRolesList;
	}

	public List<PosFile> getPosFilesList() {
		return posFilesList;
	}

	public void setPosFilesList(List<PosFile> posFilesList) {
		this.posFilesList = posFilesList;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}

	public List<PosSupplier> getPosSuppliersList() {
		return posSuppliersList;
	}

	public void setPosSuppliersList(List<PosSupplier> posSuppliersList) {
		this.posSuppliersList = posSuppliersList;
	}
	
	
}
