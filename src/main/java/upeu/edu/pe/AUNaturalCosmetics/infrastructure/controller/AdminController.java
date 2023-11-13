/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.AUNaturalCosmetics.app.service.ProductService;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
     private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("products", productService.getProducts());
        return "admin/home_admin";
        
        
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("products", productService.getProducts());
        return "admin/admin";
}
}
