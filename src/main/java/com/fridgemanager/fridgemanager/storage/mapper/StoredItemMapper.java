package com.fridgemanager.fridgemanager.storage.mapper;

import com.fridgemanager.fridgemanager.storage.domain.StoredItem;
import com.fridgemanager.fridgemanager.storage.domain.StoredItemDto;

public interface StoredItemMapper<T extends StoredItem> {

    public T map(StoredItemDto dto);
}
