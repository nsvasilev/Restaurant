package ru.vasilyev.restaurant.dao;

import ru.vasilyev.restaurant.model.OrderDetail;

import java.util.List;

public interface OrderDetailDao extends Dao <OrderDetail, Long>{
    boolean existProductInOrderDetailsByID(Long productId);
    List<OrderDetail> findAll();

    List<OrderDetail> findAllWithCondition(String condition);

    boolean exitsById(Long id);
}
