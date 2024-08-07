package ru.vasilyev.restaurant.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@FieldDefaults
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProductCategory {
     long id;
     String name;
     CategoryType type;
    // List<Product> products;
}
