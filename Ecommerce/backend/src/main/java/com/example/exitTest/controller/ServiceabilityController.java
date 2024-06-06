package com.example.exitTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exitTest.Repo.DescriptionRepo;
import com.example.exitTest.Repo.ProductRepo;
import com.example.exitTest.entity.Description;
import com.example.exitTest.entity.Product;


@RestController
public class ServiceabilityController {

	@Autowired
	ProductRepo repo;
	
	@Autowired
	DescriptionRepo desrepo;
	
	@GetMapping("/getAvailability")
	public boolean getAvailability(@RequestParam("productCode") Integer productCode, @RequestParam("pincode")Integer pincode) {
		
		Product product = repo.findByProductCode(productCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
		for(int i =0 ;i<product.getPincode().length;i++) {
			if(pincode==product.getPincode()[i]) {
				
				return true;
			}
		}
		return false;
	
	}
	
	@GetMapping("/getDate")
	@ResponseBody
	public String getDeliveryDate(@RequestParam("productCode") Integer productCode ,@RequestParam("pincode")Integer pincode) {
		Product product = repo.findByProductCode(productCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
		Description description = desrepo.findByProduct(product);
		if(getAvailability(productCode,pincode)) {
			
			return description.getDesDate();
		}
		else {
			return "Not Deliverable to that Address";
		}
		
	}
	
}
