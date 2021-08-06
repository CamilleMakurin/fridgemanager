package com.fridgemanager.fridgemanager.storage.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StoredItem {

    private QuantityUnit unit;
    private int quantity;
    private LocalDate storedOn;
    private LocalDate validTil;
}
