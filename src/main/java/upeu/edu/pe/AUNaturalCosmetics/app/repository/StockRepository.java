/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.app.repository;

import java.util.List;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.ProductEntity;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.StockEntity;

/**
 *
 * @author alejandromacedop
 */
public interface StockRepository {
    StockEntity saveStock(StockEntity stockEntity);
    List<StockEntity> getStockByProductEntity(ProductEntity productEntity);
}

