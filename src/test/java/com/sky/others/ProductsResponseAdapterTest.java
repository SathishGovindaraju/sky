package com.sky.others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.sky.others.Category.NEWS;
import static com.sky.others.Category.SPORTS;
import static com.sky.others.Channel.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ProductsResponseAdapterTest {

    private ProductsResponseAdapter adapter = new ProductsResponseAdapter();

    @Test
    public void shouldReturnResponseWithEmptyValue_whenProductsListIsEmpty(){
        final ProductsResponse productResponse = adapter.getProductResponse(new ArrayList<>());
        assertTrue(productResponse.getProducts().size() == 0);
    }

    @Test
    public void shouldReturnCorrectResponse_whenProductsListHasOneProductInOneCategory(){
        List<Product> products = asList(new Product(NEWS, SKY_NEWS));

        final ProductsResponse productResponse = adapter.getProductResponse(products);

        assertTrue(productResponse.getProducts().size() == 1);
        assertTrue(productResponse.getProducts().containsKey(NEWS));

        final List<Channel> actualChannels = productResponse.getProducts().get(NEWS);
        assertTrue(actualChannels.size() == 1);
        assertTrue(actualChannels.equals(asList(SKY_NEWS)));
    }

    @Test
    public void shouldReturnCorrectResponse_whenProductsListHasMoreThanOneProductInOneCategory(){
        List<Product> products = asList(new Product(NEWS, SKY_NEWS),new Product(NEWS, SKY_SPORTS_NEWS));

        final ProductsResponse productResponse = adapter.getProductResponse(products);

        assertTrue(productResponse.getProducts().size() == 1);
        assertTrue(productResponse.getProducts().containsKey(NEWS));

        final List<Channel> actualChannels = productResponse.getProducts().get(NEWS);

        assertTrue(actualChannels.size() == 2);
        assertTrue(actualChannels.equals(asList(SKY_NEWS,SKY_SPORTS_NEWS)));
    }

    @Test
    public void shouldReturnCorrectResponse_whenProductsListHasMoreThanOneProductInMoreThanOneCategory(){
        List<Product> products = asList(new Product(NEWS, SKY_NEWS),new Product(NEWS, SKY_SPORTS_NEWS),new Product(SPORTS, LIVERPOOL_TV),new Product(SPORTS, CHELSEA_TV));

        final ProductsResponse productResponse = adapter.getProductResponse(products);

        assertTrue(productResponse.getProducts().size() == 2);
        assertTrue(productResponse.getProducts().containsKey(NEWS));
        assertTrue(productResponse.getProducts().containsKey(SPORTS));

        final List<Channel> actualNewsChannels = productResponse.getProducts().get(NEWS);

        assertTrue(actualNewsChannels.size() == 2);
        assertTrue(actualNewsChannels.equals(asList(SKY_NEWS, SKY_SPORTS_NEWS)));

        final List<Channel> actualSportsChannels = productResponse.getProducts().get(SPORTS);

        assertTrue(actualSportsChannels.size() == 2);
        assertTrue(actualSportsChannels.equals(asList(LIVERPOOL_TV, CHELSEA_TV)));
    }
}