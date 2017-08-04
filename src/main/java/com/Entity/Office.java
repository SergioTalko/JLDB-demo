package com.Entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Transactional
@Table(name = "OFFICES")
public class Office {
    private Long office_id;
    private String name;
    private String address;
    private String tel;
    private String contact;
    private List<User> users;          //from User entity


    //Constructors

    public Office(String name, String address, String tel, String contact) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.contact = contact;

    }

    //Getters



    @Id
    @SequenceGenerator(name = "OFFICEID_SEQ", sequenceName = "OFFICEID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OFFICEID_SEQ")
    public Long getOffice_id() {
        return office_id;
    }


    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    @Column(name = "TEL")
    public String getTel() {
        return tel;
    }

    @Column(name = "CONTACT")
    public String getContact() {
        return contact;
    }


    @OrderColumn
    @OneToMany(targetEntity = User.class, mappedBy = "office", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<User> getUsers() {
        return users;
    }


    public void setOffice_id(Long office_id) {
        this.office_id = office_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}