package ru.vasilyev.restaurant.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
//@FieldDefaults
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderApproval {
    private long id;
    private OrderDetail orderDetail;
}
