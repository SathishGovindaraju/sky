package com.sky.others;

public class Product {

    private final Category category;
    private final Channel channel;

    public Product(Category category, Channel channel){
        this.category = category;
        this.channel = channel;
    }

    public Category getCategory() {
        return category;
    }

    public Channel getChannel() {
        return channel;
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        return this.category.equals(product.getCategory()) && this.channel.equals(product.getChannel());
    }
}
