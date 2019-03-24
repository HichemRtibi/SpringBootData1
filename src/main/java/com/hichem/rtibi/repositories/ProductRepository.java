package com.hichem.rtibi.repositories;

import com.hichem.rtibi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    public Product findByName(String name);

    public List<Product> findByCategoryOrDescription(String category, String description);
}
