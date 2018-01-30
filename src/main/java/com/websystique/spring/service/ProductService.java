package com.websystique.spring.service;

import com.websystique.spring.model.Product;

public interface ProductService {

    String getByName(String name);

    void refreshAllProducts();
 
 }
