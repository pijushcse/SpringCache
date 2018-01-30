package com.websystique.spring.service;

import com.samsung.gs8.GalaxyService;
import java.util.Objects;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component(value = "productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
     GalaxyService gs ;
    
    @PostConstruct
    private void init() {
       int hash = Objects.hash("Galaxy");
        gs.updateByName(hash);

    }
    
    @Override
    @Cacheable(value = "products", key = "T(java.util.Objects).hash(#p0)")
    public String getByName(String name) {
        System.out.println("Inside method");
        slowLookupOperation();
        return name + " : " + name;
    }

    @CacheEvict(value = "products", allEntries = true)
    public void refreshAllProducts() {
        //This method will remove all 'products' from cache, say as a result of flush API.
    }

    public void slowLookupOperation() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
