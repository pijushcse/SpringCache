package com.websystique.spring.configuration;

import com.samsung.gs8.GalaxyService;
import com.samsung.gs8.GalaxyServiceImpl;
import java.util.Objects;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.ClassPathResource;

@EnableCaching
@Configuration
 @ComponentScan(basePackages = {"com.websystique.spring", "com.samsung.gs8"})
public class AppConfig {

    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheCacheManager().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
        factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factory.setShared(true);
        factory.setAcceptExisting(false);
        return factory;
    }

    @Bean
    public GalaxyService galaxy() {
        GalaxyService gs = new GalaxyServiceImpl();
        return gs;
    }

}
