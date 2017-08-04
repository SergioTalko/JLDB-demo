package com.Entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Transactional
@Table(name = "USERS")
public class User {
    private Long id;
    private UserType type;
    private String email;
    private String password;
    private String name;
    private String tel;
    private Date regDate;
    private Date lastActive;
    private Long officeID;

    private Office office;  //


    //Constructors

    public User(UserType type, String email, String password, String name, String tel, Office office) {
        this.type = type;
        this.email = email;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.regDate = new Date();
        this.lastActive = null;
        this.office = office;

    }

    //Getters
    @Id
    @SequenceGenerator(name = "USERID_SEQ", sequenceName = "USERID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERID_SEQ")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "TYPE")
    public UserType getType() {
        return type;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "TEL")
    public String getTel() {
        return tel;
    }

    @Column(name = "DATE_REG")
    public Date getRegDate() {
        return regDate;
    }

    @Column(name = "LAST_ACTIVE")
    public Date getLastActive() {
        return lastActive;
    }

    @Column(name = "OFFICEID")
    public Long getOfficeID() {
        return officeID;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    public Office getOffice() {
        return office;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

    public void setOfficeID(Long officeID) {
        this.officeID = officeID;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
