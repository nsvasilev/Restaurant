package ru.vasilyev.restaurant.dao;

import ru.vasilyev.restaurant.model.ProductCategory;

import java.util.List;

public interface ProductCategoryDao extends Dao<ProductCategory, Long>{
    List<ProductCategory> findByIds(List<Long> ids);

    List<Long> findAllIds();
}
