package com.fsalac.form.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "pos_files")
public class PosFile extends ModelObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "type")
    private long type;
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
    @Column(name = "created_by")
    private long createdBy;
    @Column(name = "description")
    private String description;
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
   
    @Lob
    @Column(name = "file",columnDefinition="LONGBLOB")
    private byte[] file;
   
    @JoinColumn(name = "user_owner", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PosUser userOwner;

    public PosFile() {
    }

    public PosFile(Long id) {
        this.id = id;
    }

    public PosFile(Long id, long type, Date dateCreated, long createdBy, String filename, byte[] file) {
        this.id = id;
        this.type = type;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
        this.filename = filename;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
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

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public PosUser getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(PosUser userOwner) {
        this.userOwner = userOwner;
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
        if (!(object instanceof PosFile)) {
            return false;
        }
        PosFile other = (PosFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos.PosFile[ id=" + id + " ]";
    }
    
}
