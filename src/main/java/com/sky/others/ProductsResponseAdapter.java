package com.sky.others;

import java.util.*;

public class ProductsResponseAdapter {

    public ProductsResponse getProductResponse(List<Product> products){

        Map<Category,List<Channel>> productsResponse = new LinkedHashMap<>();

        for (Product product : products) {
            final Category category = product.getCategory();
            if(productsResponse.containsKey(category)){
                productsResponse.get(category).add(product.getChannel());
            }else {
                List<Channel> channelList = new LinkedList<>();
                channelList.add(product.getChannel());
                productsResponse.put(category, channelList);
            }
        }

        return new ProductsResponse(productsResponse);
    }
}
