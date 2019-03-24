package com.hichem.rtibi.controller;

import com.hichem.rtibi.model.Product;
import com.hichem.rtibi.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/products/")
public class ProductRestController {
    Logger logger=LoggerFactory.getLogger(ProductRestController.class);
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
    @RequestMapping(path = "{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product productUpdate(@RequestBody Product product,@PathVariable("id") String id){
        Product productFound=productRepository.findById(id).orElse(null);
        if(productFound!=null){
            productFound.setName(product.getName());
            productFound.setPrice(product.getPrice());
            productFound.setCategory(product.getCategory());
            productFound.setType(product.getType());
            productFound.setDescription(product.getDescription());
            return productRepository.save(productFound);
        }
        else{
            logger.info("product Not found");
            return product;
        }


    }
@RequestMapping(path = "{id}")
    public boolean deleteProduct(@PathVariable("id") String id){
        Product foundProduct=productRepository.findById(id).orElse(null);
        if (foundProduct!=null){
            productRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
