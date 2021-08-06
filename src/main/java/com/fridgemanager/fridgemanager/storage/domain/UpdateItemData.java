package com.fridgemanager.fridgemanager.storage.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateItemData extends StoredItem{

    private String itemName;
    private QuantityUnit quantityUnit;
    private int quantity;
    private ItemOperation operation;

}
