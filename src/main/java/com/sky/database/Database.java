package com.sky.database;

import com.sky.others.Location;
import com.sky.others.Product;

import java.util.List;

public interface Database {
    List<Product> getProductsFor(Location location);
}
