package com.fsalac.form.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fsalac
 */
@Entity
@Table(name = "pos_suppliers")
public class PosSupplier extends ModelObject {
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
    @Column(name = "date_deleted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Column(name = "updated_by")
    private Long updatedBy;
    @Column(name = "deleted_by")
    private Long deletedBy;
    @Basic(optional = false)
    
    @Column(name = "active", columnDefinition = "BIT", length = 1)
    private boolean active;
    
    @Basic(optional = false)
    @Column(name = "deleted", columnDefinition = "BIT", length = 1)
    private boolean deleted;
    
    @Column(name = "status")
    private String status;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "contact_person_name")
    private String contactPersonName;
    @Column(name = "contact_position")
    private String contactPosition;
    @Column(name = "phone_primary")
    private String phonePrimary;
    @Column(name = "phone_secondary")
    private String phoneSecondary;
    @Column(name = "fax")
    private String fax;
    @Column(name = "term")
    private String term;
    @Column(name = "discount")
    private String discount;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
   
    @ManyToOne(optional = false)
    private PosUser createdBy;

    public PosSupplier() {
    }

    public PosSupplier(Long id) {
        this.id = id;
    }

    public PosSupplier(Long id, Date dateCreated, boolean active, boolean deleted) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.active = active;
        this.deleted = deleted;
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

    public Date getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
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

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getContactPosition() {
        return contactPosition;
    }

    public void setContactPosition(String contactPosition) {
        this.contactPosition = contactPosition;
    }

    public String getPhonePrimary() {
        return phonePrimary;
    }

    public void setPhonePrimary(String phonePrimary) {
        this.phonePrimary = phonePrimary;
    }

    public String getPhoneSecondary() {
        return phoneSecondary;
    }

    public void setPhoneSecondary(String phoneSecondary) {
        this.phoneSecondary = phoneSecondary;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
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
        if (!(object instanceof PosSupplier)) {
            return false;
        }
        PosSupplier other = (PosSupplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.PosSupplier[ id=" + id + " ]";
    }
    
}
