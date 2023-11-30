package com.shinn.sneakersshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category extends Base {

    @Column
    private String name;

    @Column
    private String code;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products;
}
