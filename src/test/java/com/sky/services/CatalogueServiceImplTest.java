package com.sky.services;

import com.sky.database.ProductsDatabase;
import com.sky.others.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.sky.others.Location.LONDON;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatalogueServiceImplTest {

    @Mock
    private ProductsDatabase database;
    @Mock
    private List<Product> products;

    @InjectMocks
    private CatalogueServiceImpl catalogueService;

    @Test
    public void shouldCallDatabaseWithTheRequestedLocation(){
        when(database.getProductsFor(LONDON)).thenReturn(products);

        final List<Product> actualProducts = catalogueService.getProductsForLocation(LONDON);

        assertTrue(actualProducts.equals(products));
    }

}