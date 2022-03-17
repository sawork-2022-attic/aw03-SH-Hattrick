package com.example.webpos.db;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PosInMemoryDB implements PosDB {
    private List<Product> products = new ArrayList<>();

    private Cart cart;

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Cart saveCart(Cart cart) {
        this.cart = cart;
        return this.cart;
    }

    @Override
    public Cart getCart() {
        return this.cart;
    }

    @Override
    public Product getProduct(String productId) {
        for (Product p : getProducts()) {
            if (p.getId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    private PosInMemoryDB() {
        this.products.add(new Product("PD1", "Iron", 121, "1.jpg"));
        this.products.add(new Product("PD2", "Mosch", 231, "2.jpg"));
        this.products.add(new Product("PD3", "Bag", 342, "3.jpg"));
        this.products.add(new Product("PD4", "Phone", 478, "4.jpg"));
        this.products.add(new Product("PD5", "Sofa", 564, "5.jpg"));
        this.products.add(new Product("PD6", "Chair", 684, "6.jpg"));
        this.products.add(new Product("PD7", "Watch", 729, "7.jpg"));
        this.products.add(new Product("PD8", "Computer", 808, "comp.png"));

    }

}
