/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.OrderEntity;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer>{
      public Iterable<OrderEntity> findByUser(UserEntity user);
}
