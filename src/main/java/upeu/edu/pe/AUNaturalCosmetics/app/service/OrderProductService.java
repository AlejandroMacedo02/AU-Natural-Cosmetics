/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.app.service;

import java.util.List;
import upeu.edu.pe.AUNaturalCosmetics.app.repository.OrderProductRepository;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.OrderEntity;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.OrderProductEntity;

/**
 *
 * @author alejandromacedop
 */
public class OrderProductService {
    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }
    
     public OrderProductEntity create (OrderProductEntity orderProduct){
         return orderProductRepository.create(orderProduct);
     }
    public Iterable<OrderProductEntity> getOrderProducts(){
        return orderProductRepository.getOrderProducts();
        
    }
    public List<OrderProductEntity> getOrdersProductByOrder(OrderEntity orderEntity){
        return orderProductRepository.getOrdersProductByOrder(orderEntity);
    }
}
