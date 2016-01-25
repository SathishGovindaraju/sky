package com.sky.others;

import java.util.List;
import java.util.Map;

public class ProductsResponse {
    private final Map<Category,List<Channel>> products;

    public ProductsResponse(Map<Category, List<Channel>> products) {
        this.products = products;
    }

    public Map<Category, List<Channel>> getProducts() {
        return products;
    }
}
