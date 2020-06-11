package com.advancedjava.springwebmvc.controller;

import com.advancedjava.springwebmvc.entity.Product;
import com.advancedjava.springwebmvc.repository.ProductRepository;
import com.advancedjava.springwebmvc.validator.ProducValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/products/{id}")
    public String getProductViaPathVariable(@PathVariable int id, Model model) {
        return returnJspProductsWithId(id, model);
    }

    private String returnJspProductsWithId(@PathVariable int id, Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("selectedProduct", productRepository.findById(id));
        model.addAttribute("message", "le produit " + id + " a été recupéré");
        return "products";
    }

    @GetMapping("/products/add/")
    public String getAddProductForm(@ModelAttribute("productObject") Product product, Model model) {
        if (product == null) {
            product = new Product();
        }
        model.addAttribute("message", "Vous voulez ajouter un produit");
        return "modifyproduct";
    }

    @PostMapping("/products/add/")
    public String addProduct(@ModelAttribute("productObject") Product product, BindingResult result, Model model) {
        System.out.println(product);
        new ProducValidator().validate(product, result);
        if (result.hasErrors()) {
            return "modifyproduct";
        } else {
            productRepository.save(product);
        }
        model.addAttribute("message", "Un nouveau produit a été ajouté");
        return "redirect:/products/";
    }

    @GetMapping("/products/modify/{productId}")
    public String getProductFromForProductId(@PathVariable int productId, Model model) {
        model.addAttribute("message", "Le produit " + productId + " va être modifié");
        model.addAttribute("productObject", productRepository.findById(productId));
        return "modifyproduct";
    }

    @PostMapping("/products/modify/{productId}")
    public String updateProduct(@ModelAttribute("productObject") Product product, @PathVariable int productId, Model model) {
        product.setId(productId);
        if (product.getId() != null) {
            productRepository.save(product);
        }
        model.addAttribute("message", "Le produit " + product.getId() + " a été modifié");
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id, Model model) {
        productRepository.deleteById(id);
        model.addAttribute("message", "Le produit " + id + " a été supprimé");
        return "redirect:/products";
    }

}
