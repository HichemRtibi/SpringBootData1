package com.hichem.rtibi.controller;

import com.hichem.rtibi.model.Product;
import com.hichem.rtibi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product SaveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
}
