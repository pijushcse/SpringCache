package com.samsung.gs8;

import org.springframework.cache.annotation.CachePut;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 *
 * @author Debnatp
 */

public class GalaxyServiceImpl implements GalaxyService {

    public GalaxyServiceImpl() {
    }
    
    @Override
    @CachePut(value = "products", key = "#key")
    public String updateByName(Integer key) {
        return "Oh My Galaxy- " + key;
    }
}
