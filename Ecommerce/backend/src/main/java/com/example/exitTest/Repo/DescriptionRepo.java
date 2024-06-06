package com.example.exitTest.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.exitTest.entity.Description;
import com.example.exitTest.entity.Product;

public interface DescriptionRepo extends JpaRepository<Description, Integer> {

	
	
            
    Description findByProduct(Product product);
}
