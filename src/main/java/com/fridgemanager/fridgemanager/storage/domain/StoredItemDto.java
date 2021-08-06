package com.fridgemanager.fridgemanager.storage.domain;

import com.fridgemanager.fridgemanager.product.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoredItemDto {

    private String id;
    private String itemName;
    private QuantityUnit quantityUnit;
    private int quantity;
    private String validTil;
    private ItemOperation operation;
    private ItemType type;

}
