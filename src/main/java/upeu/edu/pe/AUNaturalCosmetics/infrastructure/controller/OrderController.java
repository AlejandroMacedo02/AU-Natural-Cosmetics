/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.infrastructure.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import upeu.edu.pe.AUNaturalCosmetics.app.domain.ItemCart;
import upeu.edu.pe.AUNaturalCosmetics.app.service.CartService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.OrderProductService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.OrderService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.ProductService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.StockService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.UserService;
import upeu.edu.pe.AUNaturalCosmetics.app.service.ValidateStock;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.OrderEntity;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.OrderProductEntity;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.StockEntity;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("/user/order")
public class OrderController {
    private final CartService cartService; 
    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;
    private final OrderProductService orderProductService;
    private Integer entradas = 0;
    private final ValidateStock validateStock;
    private final StockService stockService;
    private final Logger log = LoggerFactory.getLogger(OrderController.class);    

    public OrderController(CartService cartService, UserService userService, OrderService orderService, ProductService productService, OrderProductService orderProductService, ValidateStock validateStock, StockService stockService) {
        this.cartService = cartService;
        this.userService = userService;
        this.orderService = orderService;
        this.productService = productService;
        this.orderProductService = orderProductService;
        this.validateStock = validateStock;
        this.stockService = stockService;
    }
    
    @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model){
        UserEntity user = userService.findById(1);
        model.addAttribute("cart", cartService.getItemCarts());
        model.addAttribute("total", cartService.getTotalCart());
        model.addAttribute("user", user);
        return "user/sumaryorder";
        
    }
    @GetMapping("create-order")
    public String create (RedirectAttributes attributes){
        UserEntity user = userService.findById(1);
        OrderEntity order = new OrderEntity();
        order.setDateCreated(LocalDateTime.now());
        order.setStatus("proceso");
        order.setUser(user);
        log.info("order", order);
        
       //CREACION DE ORDEN
        orderService.createOrder(order);
        
        List<OrderProductEntity> orderProduct = new ArrayList<>();
        for(ItemCart itemCart: cartService.getItemCarts()){
            orderProduct.add(new OrderProductEntity(productService.getProductById(itemCart.getIdProduct()),
            itemCart.getQuantity(),order));
        }
        orderProduct.forEach(
        op ->{
            orderProductService.create(op);
            StockEntity stock = new StockEntity();
            stock.setDescripcion("salidas");
            stock.setEntradas(entradas);
            stock.setProductEntity(op.getProductEntity());
            stock.setSalidas(op.getQuantity());
            stockService.saveStock(validateStock.calculateBalance(stock));
        }
   
        );
            cartService.removeAllItemsCart();
        return "redirect:/home";
    }
    
}