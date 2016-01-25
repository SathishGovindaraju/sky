package com.sky.controllers;

import com.sky.others.Location;
import com.sky.others.Product;
import com.sky.others.ProductsResponse;
import com.sky.others.ProductsResponseAdapter;
import com.sky.services.CatalogueService;
import com.sky.services.CustomerLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductsController {

    private final CatalogueService catalogueService;
    private final CustomerLocationService locationService;
    private ProductsResponseAdapter adapter;

    @Autowired
    public ProductsController(CatalogueService catalogueService, CustomerLocationService locationService, ProductsResponseAdapter adapter) {
        this.catalogueService = catalogueService;
        this.locationService = locationService;
        this.adapter = adapter;
    }

    @RequestMapping("/get-products")
    public ProductsResponse getProducts(@RequestParam(value = "customerId", required = true) String customerId){
        final Location location = locationService.getLocationIdFor(customerId);
        final List<Product> products = catalogueService.getProductsForLocation(location);
        return adapter.getProductResponse(products);
    }
}
