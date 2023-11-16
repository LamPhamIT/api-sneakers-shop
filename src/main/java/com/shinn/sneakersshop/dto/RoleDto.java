package com.shinn.sneakersshop.dto;

import com.shinn.sneakersshop.model.ERole;

public class RoleDto {
    private String code;
    private ERole name;

    public RoleDto() {
    }

    public RoleDto(String code, ERole name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
