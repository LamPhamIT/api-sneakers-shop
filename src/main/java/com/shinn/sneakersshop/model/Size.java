package com.shinn.sneakersshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Size extends Base{
    @Column
    private int size;

    @Column
    private int quantity;

    @ManyToMany(mappedBy = "sizes")
    private List<Product> products;
}
