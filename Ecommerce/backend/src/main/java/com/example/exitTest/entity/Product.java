package com.example.exitTest.entity;

import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Lob;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer productCode;
	String productName;
	String productBrand;
    Integer productPrice;
	
    @Column
    String image; 
	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	int[] pincode;

	public int[] getPincode() {
		return pincode;
	}

	public void setPincode(int[] pincode) {
		this.pincode = pincode;
	}

	public Integer getProductCode() {
		return productCode;
	}

	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

	
    public Product(Integer productCode, String productName, String productBrand, int[] pincode, Integer productPrice, String image) {
        super();
        this.productCode = productCode;
        this.productName = productName;
        this.productBrand = productBrand;
        this.pincode = pincode;
        this.productPrice = productPrice;
        this.image = image;
    }

	public Product() {
		super();
	}

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Description description;

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", pincode=" + Arrays.toString(pincode) + ", description=" + description + "]";
	}
}
