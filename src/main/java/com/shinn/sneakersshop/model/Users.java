package com.shinn.sneakersshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="User")
public class Users extends Base {
    @Column(nullable = false, unique = true)
    @NotNull
    @NotEmpty
    private String username;

    @Column(nullable = false)
    @NotEmpty
    @NotNull
    private String password;

    @Column(nullable = false)
    @Email
    private String activedEmail;

    @Column(nullable = false)
    private String fullname;


    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    public Users() {
    }

    public Users(Long id,
                 Date createDate,
                 String createBy,
                 Date lastModifiedDate,
                 String lastModifiedBy,
                 String username,
                 String password,
                 String activedEmail,
                 String fullname,
                 List<Role> roles
    ) {
        super(id, createDate, createBy, lastModifiedDate, lastModifiedBy);
        this.username = username;
        this.password = password;
        this.activedEmail = activedEmail;
        this.fullname = fullname;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivedEmail() {
        return activedEmail;
    }

    public void setActivedEmail(String activedEmail) {
        this.activedEmail = activedEmail;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
