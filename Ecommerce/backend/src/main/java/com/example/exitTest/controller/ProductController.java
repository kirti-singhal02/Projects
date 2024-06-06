package com.example.exitTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.exitTest.Repo.DescriptionRepo;
import com.example.exitTest.Repo.ProductRepo;
import com.example.exitTest.entity.Description;
import com.example.exitTest.entity.Product;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
public class ProductController {
	@Autowired
	ProductRepo repo;
	
    @Autowired
    DescriptionRepo desrepo;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        repo.save(product);
        return product;

    }



	@GetMapping("/products")
	public List<Product> listProducts() {
		return repo.findAll();
	}

	@GetMapping("/search")
	public List<Product> searchProducts(@RequestParam("productName") String productName,
			@RequestParam("productBrand") String productBrand, @RequestParam("productCode") String productCode) {
		List<Product> products = repo.searchProducts(productName, productBrand, productCode);
		
		return products;
	}
	@GetMapping("/getPrice")
	@ResponseBody
	public Integer getPrice(@RequestParam("productCode") Integer productCode) {
		Product product = repo.findByProductCode(productCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
		
		return product.getProductPrice();
		
	}

	
//Details

	@PostMapping("/addDescription")
     public Description addProduct(@RequestBody Description description, @RequestParam("productCode") Integer productCode) throws IllegalArgumentException {
           Product product = repo.findByProductCode(productCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
				description.setProduct(product);
				desrepo.save(description);
				return description;
	}
	
	@GetMapping("/getDescription")
	@ResponseBody
	public Description getDescription(@RequestParam("productCode") Integer productCode) {
		Product product = repo.findByProductCode(productCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
		Description description = desrepo.findByProduct(product);
		return description;
		
	}
	
	
	@GetMapping("/getAll")
	 public List<Integer> getPricesByProductCodes(@RequestParam("productCodes") String productCodes) {
    ArrayList<Integer> prices = new ArrayList<>();
	     String[] productCodeArray = productCodes.split(",");
	     for (String code : productCodeArray) {
	         Integer productCode = Integer.parseInt(code.trim());
	         Product product = repo.findByProductCode(productCode)
               .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
         
	         prices.add(product.getProductPrice());

	     }
     return prices;

	 }

}
