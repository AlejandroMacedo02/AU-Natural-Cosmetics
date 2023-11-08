/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.app.service;

import java.util.List;
import upeu.edu.pe.AUNaturalCosmetics.app.repository.StockRepository;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.ProductEntity;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.StockEntity;

/**
 *
 * @author alejandromacedop
 */
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockEntity saveStock(StockEntity stockEntity) {
        return stockRepository.saveStock(stockEntity);
    }

    public List<StockEntity> getStockByProduct(ProductEntity productEntity) {
        return stockRepository.getStockByProductEntity(productEntity);

    }
}
