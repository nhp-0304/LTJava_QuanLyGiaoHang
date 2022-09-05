/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Orders.findByRequiredDate", query = "SELECT o FROM Orders o WHERE o.requiredDate = :requiredDate"),
    @NamedQuery(name = "Orders.findByShippedDate", query = "SELECT o FROM Orders o WHERE o.shippedDate = :shippedDate"),
    @NamedQuery(name = "Orders.findByShipName", query = "SELECT o FROM Orders o WHERE o.shipName = :shipName"),
    @NamedQuery(name = "Orders.findByShipAddress", query = "SELECT o FROM Orders o WHERE o.shipAddress = :shipAddress"),
    @NamedQuery(name = "Orders.findByShipPostalcode", query = "SELECT o FROM Orders o WHERE o.shipPostalcode = :shipPostalcode"),
    @NamedQuery(name = "Orders.findByShipStatus", query = "SELECT o FROM Orders o WHERE o.shipStatus = :shipStatus"),
    @NamedQuery(name = "Orders.findByPaymentStatus", query = "SELECT o FROM Orders o WHERE o.paymentStatus = :paymentStatus")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "required_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requiredDate;
    @Column(name = "shipped_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippedDate;
    @Size(max = 100)
    @Column(name = "ship_name")
    private String shipName;
    @Size(max = 100)
    @Column(name = "ship_address")
    private String shipAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ship_postalcode")
    private int shipPostalcode;
    @Column(name = "ship_status")
    private Boolean shipStatus;
    @Column(name = "payment_status")
    private Boolean paymentStatus;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private City cityId;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Customer customerId;
    @JoinColumn(name = "shipper_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Shipper shipperId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    @JsonIgnore
    private Set<OrdersDetail> ordersDetailSet;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Orders(Integer id, int shipPostalcode) {
        this.id = id;
        this.shipPostalcode = shipPostalcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public int getShipPostalcode() {
        return shipPostalcode;
    }

    public void setShipPostalcode(int shipPostalcode) {
        this.shipPostalcode = shipPostalcode;
    }

    public Boolean getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(Boolean shipStatus) {
        this.shipStatus = shipStatus;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Shipper getShipperId() {
        return shipperId;
    }

    public void setShipperId(Shipper shipperId) {
        this.shipperId = shipperId;
    }

    @XmlTransient
    public Set<OrdersDetail> getOrdersDetailSet() {
        return ordersDetailSet;
    }

    public void setOrdersDetailSet(Set<OrdersDetail> ordersDetailSet) {
        this.ordersDetailSet = ordersDetailSet;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhpvtl.pojo.Orders[ id=" + id + " ]";
    }
    
}
