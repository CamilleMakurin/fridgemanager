package com.fridgemanager.fridgemanager.storage.domain;

import com.fridgemanager.fridgemanager.StoredObject;
import com.fridgemanager.fridgemanager.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Storage implements StoredObject {

    private String id;
    private User storageOwner;
    private List<StoredDish> dishes;
    private List<StoredProduct> products;

    @Override
    public String getId() {
        return storageOwner.getName();
    }

    public void addDish(StoredDish dish) {
        if (dishes == null) {
            dishes = new ArrayList<>();
        }
        dishes.add(dish);
    }

    public void addProduct(StoredProduct product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }

    public void removeDish(String dishName) {
        dishes.removeIf(p -> p.getDish().getName().equals(dishName));

    }

    public void removeProduct(String productName) {
        products.removeIf(p -> p.getProduct().getName().equals(productName));
    }

    public void updateDish(UpdateItemData data) {
        Optional<StoredDish> dishOpt = dishes.stream().filter(d -> d.getDish().getName().equals(data.getItemName())).findAny();
        if (dishOpt.isPresent()) {
            StoredDish storedDish = dishOpt.get();
            storedDish.setQuantity(data.getQuantity());
        }

    }

    public void updateProduct(UpdateItemData data) {
        Optional<StoredProduct> productOpt = products.stream().filter(d -> d.getProduct().getName().equals(data.getItemName())).findAny();
        if (productOpt.isPresent()) {
            StoredProduct storedProduct = productOpt.get();
            storedProduct.setQuantity(data.getQuantity());
        }
    }
}
