package com.example.exitTest.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.exitTest.entity.Product;
import com.example.exitTest.entity.User;

public interface ProductRepo extends JpaRepository<Product,String> {

	@Query("SELECT prod FROM Product prod WHERE " +
            "prod.productName LIKE CONCAT('%',:productName, '%')" +
            "AND prod.productBrand LIKE CONCAT('%', :productBrand, '%')"+
"AND prod.productCode LIKE CONCAT('%', :productCode, '%') ")
    List<Product> searchProducts(String productName,
    		String productBrand,
    		String productCode);
	
	Optional<Product> findByProductCode(Integer productCode);
}
