/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "shipper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipper.findAll", query = "SELECT s FROM Shipper s"),
    @NamedQuery(name = "Shipper.findById", query = "SELECT s FROM Shipper s WHERE s.id = :id"),
    @NamedQuery(name = "Shipper.findByLicensePlate", query = "SELECT s FROM Shipper s WHERE s.licensePlate = :licensePlate"),
    @NamedQuery(name = "Shipper.findByAvatarShipper", query = "SELECT s FROM Shipper s WHERE s.avatarShipper = :avatarShipper")})
public class Shipper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45, message = "{shipper.licensePlate.nullErr}")
    @Column(name = "license_plate")
    private String licensePlate;
    @Size(max = 300)
    @Column(name = "avatar_shipper")
    private String avatarShipper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipperId")
    @JsonIgnore
    private Set<Feedback> feedbackSet;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private City cityId;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private UserAccount accountId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipperId")
    @JsonIgnore
    private Set<Orders> ordersSet;

    public Shipper() {
    }

    public Shipper(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getAvatarShipper() {
        return avatarShipper;
    }

    public void setAvatarShipper(String avatarShipper) {
        this.avatarShipper = avatarShipper;
    }

    @XmlTransient
    public Set<Feedback> getFeedbackSet() {
        return feedbackSet;
    }

    public void setFeedbackSet(Set<Feedback> feedbackSet) {
        this.feedbackSet = feedbackSet;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public UserAccount getAccountId() {
        return accountId;
    }

    public void setAccountId(UserAccount accountId) {
        this.accountId = accountId;
    }

    @XmlTransient
    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
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
        if (!(object instanceof Shipper)) {
            return false;
        }
        Shipper other = (Shipper) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhpvtl.pojo.Shipper[ id=" + id + " ]";
    }
    
}
