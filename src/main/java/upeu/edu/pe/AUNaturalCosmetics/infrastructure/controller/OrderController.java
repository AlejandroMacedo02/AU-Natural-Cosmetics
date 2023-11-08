/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.infrastructure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.AUNaturalCosmetics.app.service.CartService;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("/user/order")
public class OrderController {
    private final CartService cartService;    
    private final Logger log = LoggerFactory.getLogger(OrderController.class);    
        

    public OrderController(CartService cartService) {
        this.cartService = cartService;
    }
    
    @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model){
        UserEntity user = new UserEntity();
        user.setFirtName("Alejandro");
        user.setLastName("Macedo Paredes");
        user.setEmail("alejandromacedo@upeu.edu.pe");
        user.setAddress("upeu");
        
        model.addAttribute("cart", cartService.getItemCarts());
        model.addAttribute("total", cartService.getTotalCart());
        model.addAttribute("user", user);
        return "user/sumaryorder";
        
    }
    
}
