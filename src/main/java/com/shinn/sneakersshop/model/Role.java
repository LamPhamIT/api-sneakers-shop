package com.shinn.sneakersshop.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Role")
public class Role extends Base {
    @Column
    private String code;

    @Column
    @Enumerated(EnumType.STRING)
    private ERole name;

    @ManyToMany(mappedBy = "roles")
    private List<Users> user;

    public Role() {
    }

    public Role(Long id,
                Date createDate,
                String createBy,
                Date lastModifiedDate,
                String lastModifiedBy,
                String code,
                ERole name,
                List<Users> user
    ) {
        super(id, createDate, createBy, lastModifiedDate, lastModifiedBy);
        this.code = code;
        this.name = name;
        this.user = user;
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

    public List<Users> getUser() {
        return user;
    }

    public void setUser(List<Users> user) {
        this.user = user;
    }
}
