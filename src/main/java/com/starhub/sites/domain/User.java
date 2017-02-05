package com.starhub.sites.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @Size(min = 0, max = 100)
    @Column(name = "user_code")
    private String userName;

    @JsonIgnore
    @Size(min = 0, max = 100)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
