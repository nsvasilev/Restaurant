package ru.vasilyev.restaurant.model;

public enum OrderStatus {
    RECEIVED, // Заказ получен
    PREPARATION, // Заказ на приготовлении
    COOKING, // Заказ готовится
    READY_FOR_DELIVERY, // Заказ готов к доставке
    OUT_FOR_DELIVERY, // Заказ отправлен в доставку
    DELIVERED, // Заказ доставлен
    CANCELLED // Заказ отменён
}
