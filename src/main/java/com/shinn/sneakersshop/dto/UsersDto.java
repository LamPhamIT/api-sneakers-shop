package com.shinn.sneakersshop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public class UsersDto extends BaseDto {
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @Email
    @NotNull
    @NotEmpty
    private String activedEmail;

    @NotEmpty
    private List<RoleDto> roles;

    public UsersDto() {
    }

    public UsersDto(Long id,
                    Date createdDate,
                    String createdBy,
                    Date lastModifiedDate,
                    String lastModifiedBy,
                    String username,
                    String password,
                    String activedEmail,
                    List<RoleDto> roles) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy);
        this.username = username;
        this.password = password;
        this.activedEmail = activedEmail;
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

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }
}