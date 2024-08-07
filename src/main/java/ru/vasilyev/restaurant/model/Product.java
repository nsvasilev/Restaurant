package ru.vasilyev.restaurant.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@FieldDefaults
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
    private long id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private boolean available;
    private List<Long> productCategories;

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
