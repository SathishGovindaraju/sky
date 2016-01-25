package com.sky.endpoint_tests;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sky.controllers.ProductsController;
import com.sky.database.ProductsDatabase;
import com.sky.others.ProductsResponseAdapter;
import com.sky.services.CatalogueServiceImpl;
import com.sky.services.StubCustomerLocationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ProductsControllerEndpointTests {

    private MockMvc mvc;
    private ProductsController controller = new ProductsController(new CatalogueServiceImpl(new ProductsDatabase()), new StubCustomerLocationService(), new ProductsResponseAdapter());

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void shouldGetCorrectJsonWhenCustomerIdIs_londonCustomer() throws Exception {
        String expectJson = "{\"products\":{\"NEWS\":[\"SKY_NEWS\",\"SKY_SPORTS_NEWS\"],\"SPORTS\":[\"CHELSEA_TV\",\"ARSENAL_TV\"]}}";
        mvc.perform(MockMvcRequestBuilders.get("/api/get-products?customerId=londonCustomer"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectJson));
    }

    @Test
    public void shouldGetCorrectJsonWhenCustomerIdIs_liverpoolCustomer() throws Exception {
        String expectJson = "{\"products\":{\"NEWS\":[\"SKY_NEWS\",\"SKY_SPORTS_NEWS\"],\"SPORTS\":[\"LIVERPOOL_TV\"]}}";
        mvc.perform(MockMvcRequestBuilders.get("/api/get-products?customerId=liverpoolCustomer"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectJson));
    }

    @Test
    public void shouldThrowExceptionWhenInvalidCustomerId() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/get-products?customerId=invalidId"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldThrowExceptionWhenNoCustomerId() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/get-products"))
                .andExpect(status().isBadRequest());
    }
}