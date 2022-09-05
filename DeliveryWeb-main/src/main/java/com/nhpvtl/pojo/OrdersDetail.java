/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "orders_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdersDetail.findAll", query = "SELECT o FROM OrdersDetail o"),
    @NamedQuery(name = "OrdersDetail.findById", query = "SELECT o FROM OrdersDetail o WHERE o.id = :id"),
    @NamedQuery(name = "OrdersDetail.findByProductName", query = "SELECT o FROM OrdersDetail o WHERE o.productName = :productName"),
    @NamedQuery(name = "OrdersDetail.findByShipPrice", query = "SELECT o FROM OrdersDetail o WHERE o.shipPrice = :shipPrice"),
    @NamedQuery(name = "OrdersDetail.findByOrderStatus", query = "SELECT o FROM OrdersDetail o WHERE o.orderStatus = :orderStatus")})
public class OrdersDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "product_name")
    private String productName;
    @Column(name = "ship_price")
    private Long shipPrice;
    @Column(name = "order_status")
    private Boolean orderStatus;
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Discount discountId;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Orders orderId;

    public OrdersDetail() {
    }

    public OrdersDetail(Integer id) {
        this.id = id;
    }

    public OrdersDetail(Integer id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(Long shipPrice) {
        this.shipPrice = shipPrice;
    }

    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Discount getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Discount discountId) {
        this.discountId = discountId;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof OrdersDetail)) {
            return false;
        }
        OrdersDetail other = (OrdersDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhpvtl.pojo.OrdersDetail[ id=" + id + " ]";
    }
    
}
