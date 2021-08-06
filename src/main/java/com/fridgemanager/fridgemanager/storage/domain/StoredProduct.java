package com.fridgemanager.fridgemanager.storage.domain;

import com.fridgemanager.fridgemanager.product.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoredProduct extends StoredItem{

    private String id;
    private Product product;

}
