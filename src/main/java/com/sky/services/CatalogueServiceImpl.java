package com.sky.services;

import com.sky.database.Database;
import com.sky.others.Location;
import com.sky.others.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    private final Database database;

    @Autowired
    public CatalogueServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<Product> getProductsForLocation(Location location) {
        return database.getProductsFor(location);
    }
}
