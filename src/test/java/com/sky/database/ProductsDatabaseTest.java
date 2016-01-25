package com.sky.database;

import com.sky.others.Product;
import org.junit.Test;

import java.util.List;

import static com.sky.others.Category.NEWS;
import static com.sky.others.Category.SPORTS;
import static com.sky.others.Channel.*;
import static com.sky.others.Location.LIVERPOOL;
import static com.sky.others.Location.LONDON;
import static com.sky.others.Location.NONE;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ProductsDatabaseTest {

    private ProductsDatabase database = new ProductsDatabase();

    @Test
    public void shouldReturnCorrectProducts_whenLocationIs_Null(){
        final List<Product> products = database.getProductsFor(null);

        List<Product> expected = asList(new Product(NEWS, SKY_NEWS), new Product(NEWS, SKY_SPORTS_NEWS));

        assertTrue(products.size() == 2);
        assertTrue(expected.containsAll(products));
    }

    @Test
    public void shouldReturnCorrectProducts_whenLocationIs_NONE(){
        final List<Product> products = database.getProductsFor(NONE);

        List<Product> expected = asList(new Product(NEWS, SKY_NEWS), new Product(NEWS, SKY_SPORTS_NEWS));

        assertTrue(products.size() == 2);
        assertTrue(expected.containsAll(products));
    }

    @Test
    public void shouldReturnCorrectProducts_whenLocationIs_LONDON(){
        final List<Product> products = database.getProductsFor(LONDON);

        List<Product> expected = asList(new Product(NEWS, SKY_NEWS), new Product(NEWS, SKY_SPORTS_NEWS), new Product(SPORTS, ARSENAL_TV),new Product(SPORTS, CHELSEA_TV));

        assertTrue(products.size() == 4);
        assertTrue(expected.containsAll(products));
    }

    @Test
    public void shouldReturnCorrectProducts_whenLocationIs_LIVERPOOL(){
        final List<Product> products = database.getProductsFor(LIVERPOOL);

        List<Product> expected = asList(new Product(NEWS, SKY_NEWS), new Product(NEWS, SKY_SPORTS_NEWS), new Product(SPORTS, LIVERPOOL_TV));

        assertTrue(products.size() == 3);
        assertTrue(expected.containsAll(products));
    }

}