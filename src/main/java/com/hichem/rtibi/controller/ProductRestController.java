package com.hichem.rtibi.controller;

import com.hichem.rtibi.model.Product;
import com.hichem.rtibi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/products/")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(path = "{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") String id){
        return productRepository.findById(id).orElse(null);

    }
}
