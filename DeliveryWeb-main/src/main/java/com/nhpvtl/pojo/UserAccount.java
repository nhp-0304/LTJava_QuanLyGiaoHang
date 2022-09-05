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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "user_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccount.findAll", query = "SELECT u FROM UserAccount u"),
    @NamedQuery(name = "UserAccount.findById", query = "SELECT u FROM UserAccount u WHERE u.id = :id"),
    @NamedQuery(name = "UserAccount.findByUserName", query = "SELECT u FROM UserAccount u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserAccount.findByUserPassword", query = "SELECT u FROM UserAccount u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "UserAccount.findByUserFirstname", query = "SELECT u FROM UserAccount u WHERE u.userFirstname = :userFirstname"),
    @NamedQuery(name = "UserAccount.findByUserLastname", query = "SELECT u FROM UserAccount u WHERE u.userLastname = :userLastname"),
    @NamedQuery(name = "UserAccount.findByUserDateofbirth", query = "SELECT u FROM UserAccount u WHERE u.userDateofbirth = :userDateofbirth"),
    @NamedQuery(name = "UserAccount.findByUserGender", query = "SELECT u FROM UserAccount u WHERE u.userGender = :userGender"),
    @NamedQuery(name = "UserAccount.findByUserAddress", query = "SELECT u FROM UserAccount u WHERE u.userAddress = :userAddress"),
    @NamedQuery(name = "UserAccount.findByUserPhonenumber", query = "SELECT u FROM UserAccount u WHERE u.userPhonenumber = :userPhonenumber"),
    @NamedQuery(name = "UserAccount.findByUserGmail", query = "SELECT u FROM UserAccount u WHERE u.userGmail = :userGmail"),
    @NamedQuery(name = "UserAccount.findByUserCitizenidentitycard", query = "SELECT u FROM UserAccount u WHERE u.userCitizenidentitycard = :userCitizenidentitycard"),
    @NamedQuery(name = "UserAccount.findByUserActive", query = "SELECT u FROM UserAccount u WHERE u.userActive = :userActive"),
    @NamedQuery(name = "UserAccount.findByUserRole", query = "SELECT u FROM UserAccount u WHERE u.userRole = :userRole"),
    @NamedQuery(name = "UserAccount.findByUserAvatar", query = "SELECT u FROM UserAccount u WHERE u.userAvatar = :userAvatar")})
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String CUSTOMER = "ROLE_CUSTOMER";
    public static final String SHIPPER = "ROLE_SHIPPER";
    public static final String ADMIN = "ROLE_ADMIN";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100, message = "{user.username.sizeMsg}")
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "user_password")
    @NotEmpty(message = "{user.password.sizeMsg}")
    private String userPassword;
    @Transient
    private String confirmPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "user_firstname")
    private String userFirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "user_lastname")
    private String userLastname;
    @Basic(optional = false)
    @Column(name = "user_dateofbirth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userDateofbirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_gender")
    private String userGender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "user_address")
    private String userAddress;
    @Basic(optional = false)
    @Column(name = "user_phonenumber")
    private int userPhonenumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "user_gmail")
    private String userGmail;
    @Basic(optional = false)
    @Column(name = "user_citizenidentitycard")
    private int userCitizenidentitycard;
    @Column(name = "user_active")
    private Boolean userActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "user_role")
    private String userRole;
    @Transient
    private String confirmUserPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    @JsonIgnore
    private Set<Shipper> shipperSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    @JsonIgnore
    private Set<Customer> customerSet;

//    LenVo
    @Size(max = 300)
    @Column(name = "user_avatar")
    private String userAvatar;
    @Transient
    @JsonIgnore
    private MultipartFile file;

    public UserAccount() {
    }

    public UserAccount(Integer id) {
        this.id = id;
    }

    public UserAccount(Integer id, String userName, String userPassword, String userFirstname, String userLastname, Date userDateofbirth, String userGender, String userAddress, int userPhonenumber, String userGmail, int userCitizenidentitycard, String userRole, String userAvatar) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userDateofbirth = userDateofbirth;
        this.userGender = userGender;
        this.userAddress = userAddress;
        this.userPhonenumber = userPhonenumber;
        this.userGmail = userGmail;
        this.userCitizenidentitycard = userCitizenidentitycard;
        this.userRole = userRole;
        this.userAvatar = userAvatar;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public Date getUserDateofbirth() {
        return userDateofbirth;
    }

    public void setUserDateofbirth(Date userDateofbirth) {
        this.userDateofbirth = userDateofbirth;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(int userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }

    public String getUserGmail() {
        return userGmail;
    }

    public void setUserGmail(String userGmail) {
        this.userGmail = userGmail;
    }

    public int getUserCitizenidentitycard() {
        return userCitizenidentitycard;
    }

    public void setUserCitizenidentitycard(int userCitizenidentitycard) {
        this.userCitizenidentitycard = userCitizenidentitycard;
    }

    public Boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @XmlTransient
    public Set<Shipper> getShipperSet() {
        return shipperSet;
    }

    public void setShipperSet(Set<Shipper> shipperSet) {
        this.shipperSet = shipperSet;
    }

    @XmlTransient
    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
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
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhpvtl.pojo.UserAccount[ id=" + id + " ]";
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the confirmUserPassword
     */
    public String getConfirmUserPassword() {
        return confirmUserPassword;
    }

    /**
     * @param confirmUserPassword the confirmUserPassword to set
     */
    public void setConfirmUserPassword(String confirmUserPassword) {
        this.confirmUserPassword = confirmUserPassword;
    }

    /**
     * @return the userAvatar
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * @param userAvatar the userAvatar to set
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
