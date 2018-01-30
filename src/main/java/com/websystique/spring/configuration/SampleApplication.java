package com.websystique.spring.configuration;

import com.samsung.gs8.GalaxyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.websystique.spring.service.ProductService;
import java.util.Objects;

public class SampleApplication {

    private static final Logger logger = LoggerFactory.getLogger(SampleApplication.class);

    public SampleApplication() {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService service = (ProductService) context.getBean("productService");

//        GalaxyService gs = (GalaxyService) context.getBean("galaxy");
//         int hash = Objects.hash("Galaxy");
//         gs.updateByName(hash);

        System.out.println("IPhone ->" + service.getByName("IPhone"));
        System.out.println("IPhone ->" + service.getByName("IPhone"));
        System.out.println("IPhone ->" + service.getByName("IPhone"));

        System.out.println("Galaxy S8 ->" + service.getByName("Galaxy"));

        System.out.println("Refreshing all products");
        service.refreshAllProducts();
        System.out.println("IPhone [after refresh]->" + service.getByName("IPhone"));
        System.out.println("IPhone [after refresh]->" + service.getByName("IPhone"));
        System.out.println("IPhone [after refresh]->" + service.getByName("IPhone"));

        ((AbstractApplicationContext) context).close();
    }

    public static void main(String[] args) {
        new SampleApplication();
    }

}
