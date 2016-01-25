package com.sky.database;

import com.sky.others.Category;
import com.sky.others.Channel;
import com.sky.others.Location;
import com.sky.others.Product;

import java.util.*;

import static java.util.Arrays.asList;

public class ProductsDatabase implements Database {
    private static Map<Location,List<Product>> database = populateDatabase();

    public List<Product> getProductsFor(Location location) {
        List<Product> defaultProducts = database.get(Location.NONE);

        if(location == null || location == Location.NONE){
            return defaultProducts;
        }

        List<Product> products = database.get(location);

        List<Product> productsList = new LinkedList<>();
        productsList.addAll(defaultProducts);
        productsList.addAll(products);

        return productsList;
    }

    private static Map<Location, List<Product>> populateDatabase() {
        Map<Location,List<Product>> database = new HashMap<Location,List<Product>>();

        populateDefaultLocationProducts(database);
        populateLiverpoolLocationProducts(database);
        populateLondonLocationProducts(database);

        return database;
    }

    private static void populateDefaultLocationProducts(Map<Location, List<Product>> database) {
        List<Product> defaultList = asList(new Product(Category.NEWS, Channel.SKY_NEWS),new Product(Category.NEWS, Channel.SKY_SPORTS_NEWS));
        database.put(Location.NONE,defaultList);
    }

    private static void populateLondonLocationProducts(Map<Location, List<Product>> database) {
        List<Product> defaultList = asList(new Product(Category.SPORTS, Channel.CHELSEA_TV),new Product(Category.SPORTS, Channel.ARSENAL_TV));
        database.put(Location.LONDON,defaultList);
    }

    private static void populateLiverpoolLocationProducts(Map<Location, List<Product>> database) {
        List<Product> defaultList = asList(new Product(Category.SPORTS, Channel.LIVERPOOL_TV));
        database.put(Location.LIVERPOOL,defaultList);
    }
}
