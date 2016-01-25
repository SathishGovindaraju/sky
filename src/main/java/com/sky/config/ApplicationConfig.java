package com.sky.config;

import com.sky.database.Database;
import com.sky.others.ProductsResponseAdapter;
import com.sky.services.CatalogueService;
import com.sky.services.CatalogueServiceImpl;
import com.sky.services.StubCustomerLocationService;
import com.sky.database.ProductsDatabase;
import com.sky.services.CustomerLocationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sky.controllers")
@EnableAutoConfiguration
public class ApplicationConfig {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }

    @Bean
    public CatalogueService getCatalogueService(Database database){
        return new CatalogueServiceImpl(database);
    }

    @Bean
    public Database getDatabase(){
        return new ProductsDatabase();
    }

    @Bean
    public CustomerLocationService getCustomerLocationService(){
        return new StubCustomerLocationService();
    }

    @Bean
    public ProductsResponseAdapter getProductsResponseAdapter(){
        return new ProductsResponseAdapter();
    }
}
