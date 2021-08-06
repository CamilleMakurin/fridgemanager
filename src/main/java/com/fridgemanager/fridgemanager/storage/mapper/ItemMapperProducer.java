package com.fridgemanager.fridgemanager.storage.mapper;

import com.fridgemanager.fridgemanager.storage.domain.ItemType;
import com.fridgemanager.fridgemanager.storage.domain.StoredItemDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemMapperProducer {


    public StoredItemMapper getMapper(StoredItemDto dto) {
         return ItemType.PRODUCT.name().equals(dto.getType())? new StoredProductMapper(): new StoredDishMapper();
    }


}
