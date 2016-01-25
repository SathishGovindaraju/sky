package com.sky.services;

import com.sky.others.Location;
import com.sky.others.Product;

import java.util.List;

public interface CatalogueService {
    List<Product> getProductsForLocation(Location location);
}
