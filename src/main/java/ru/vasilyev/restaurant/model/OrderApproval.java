package ru.vasilyev.restaurant.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
public class OrderApproval {
    private long id;
    private OrderDetail orderDetail;
}
