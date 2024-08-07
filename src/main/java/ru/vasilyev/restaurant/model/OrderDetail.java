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
public class OrderDetail {
    private Long id;
    private OrderStatus orderStatus;
    private List<Long> products;
    private BigDecimal totalAmount;


}
