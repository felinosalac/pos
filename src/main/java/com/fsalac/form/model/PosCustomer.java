package com.fsalac.form.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fsalac
 */
@Entity
@Table(name = "pos_customers")
public class PosCustomer extends ModelObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Column(name = "date_deleted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @Column(name = "updated_by")
    private Long updatedBy;
    @Column(name = "deleted_by")
    private Long deletedBy;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "maximum_credit_line")
    private Long maximumCreditLine;
    @Column(name = "credit_term")
    private Long creditTerm;
    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;
   
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PosUser createdBy;
    
    @Lob
	@Column(name = "profile_picture",columnDefinition="LONGBLOB")
	private byte[] profilePicture;

	@Lob
	@Column(name = "signature",columnDefinition="LONGBLOB")
	private byte[] signature;

    public PosCustomer() {
    }

    public PosCustomer(Long id) {
        this.id = id;
    }

    public PosCustomer(Long id, Date dateCreated, String firstName, String lastName, String address) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PosUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(PosUser createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PosCustomer)) {
            return false;
        }
        PosCustomer other = (PosCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos.PosCustomer[ id=" + id + " ]";
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
