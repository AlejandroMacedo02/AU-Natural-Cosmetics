/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import upeu.edu.pe.AUNaturalCosmetics.app.repository.OrderProductRepository;
import upeu.edu.pe.AUNaturalCosmetics.app.repository.OrderRepository;
import upeu.edu.pe.AUNaturalCosmetics.app.repository.ProductRepository;
import upeu.edu.pe.AUNaturalCosmetics.app.repository.StockRepository;
import upeu.edu.pe.AUNaturalCosmetics.app.repository.UserRepository;
import upeu.edu.pe.AUNaturalCosmetics.app.service.CartService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.OrderProductService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.OrderService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.ProductService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.StockService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.UploadFile;
import upeu.edu.pe.AUNaturalCosmetics.app.service.UserService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.ValidateStock;

/**
 *
 * @author alejandromacedop
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile) {
        return new ProductService(productRepository, uploadFile);
    }

    @Bean
    public StockService stockService(StockRepository stockRepository) {
        return new StockService(stockRepository);
    }

    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }   

    @Bean
    public ValidateStock validateStock(StockService stockService) {
        return new ValidateStock(stockService);
    }
    @Bean
    public OrderService orderService(OrderRepository orderRepository){
        return new OrderService(orderRepository);
    }

    @Bean
    public OrderProductService orderProductService(OrderProductRepository orderProductRepository){
        return  new OrderProductService(orderProductRepository);
    }
    
    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
    
     @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public  CartService cartService(){
        return  new CartService();
    }
}
