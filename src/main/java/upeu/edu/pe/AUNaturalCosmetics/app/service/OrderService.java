/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.app.service;

import upeu.edu.pe.AUNaturalCosmetics.app.repository.OrderRepository;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.OrderEntity;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.createOrder(order);
    }

    public Iterable<OrderEntity> getOrders() {
        return orderRepository.getOrders();
    }

    public Iterable<OrderEntity> getOrdersByUser(UserEntity user) {
        return orderRepository.getOrdersByUser(user);

    }
}
