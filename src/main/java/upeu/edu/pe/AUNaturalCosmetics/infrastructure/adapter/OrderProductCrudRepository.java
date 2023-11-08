/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.infrastructure.adapter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.OrderEntity;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.OrderProductEntity;

/**
 *
 * @author alejandromacedop
 */
public interface OrderProductCrudRepository extends CrudRepository<OrderProductEntity, Integer>{
    public List<OrderProductEntity> findByOrderEntity(OrderEntity orderEntity); 
}
