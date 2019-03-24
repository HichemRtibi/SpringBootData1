package com.hichem.rtibi;

import com.hichem.rtibi.model.Product;
import com.hichem.rtibi.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private Logger logger=LoggerFactory.getLogger(DemoApplication.class);
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product("product1", "GENERAL", "category1", "description1", 19.00);

        Product product2 = new Product("product2", "CUSTOM", "category2", "description1", 12.00);

        Product product3 = new Product("product1", "SPECEFIC", "category3", "description1", 10.00);
        productRepository.save(product);
        productRepository.save(product2);
        productRepository.save(product3);


        Product productbYtYPE=productRepository.findByName("product2");
        logger.info("product By Name :"+productbYtYPE.toString());
    }

}
