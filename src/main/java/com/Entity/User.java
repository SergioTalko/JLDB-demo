package com.Entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Transactional
@Table(name = "USERS")
public class User {
    private Long user_id;
    private UserType type;
    private String email;
    private String password;
    private String user_name;
    private String phone;
    private Date date_registered;
    private Date last_active_date;

    private Office office;  //


    //Constructors


    public User() {
    }

    public User(UserType type, String email, String password, String user_name, String phone) {
        this.type = type;
        this.email = email;
        this.password = password;
        this.user_name = user_name;
        this.phone = phone;
        this.date_registered = new Date();
        this.last_active_date = new Date();
        

    }

    //Getters
    @Id
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    public Long getUser_id() {
        return user_id;
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

    @Column(name = "USER_NAME")
    public String getUser_name() {
        return user_name;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }


    @Column(name = "DATE_REGISTERED")
    public Date getDate_registered() {
        return date_registered;
    }


    @Column(name = "LAST_ACTIVE_DATE")
    public Date getLast_active_date() {
        return last_active_date;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    public Office getOffice() {
        return office;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDate_registered(Date date_registered) {
        this.date_registered = date_registered;
    }

    public void setLast_active_date(Date last_active_date) {
        this.last_active_date = last_active_date;
    }


    public void setOffice(Office office) {
        this.office = office;
    }
}
