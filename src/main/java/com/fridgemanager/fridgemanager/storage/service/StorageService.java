package com.fridgemanager.fridgemanager.storage.service;


import com.fridgemanager.fridgemanager.dish.DishRepository;
import com.fridgemanager.fridgemanager.product.ProductRepository;
import com.fridgemanager.fridgemanager.storage.domain.*;
import com.fridgemanager.fridgemanager.storage.mapper.ItemMapperProducer;
import com.fridgemanager.fridgemanager.storage.mapper.StoredItemMapper;
import com.fridgemanager.fridgemanager.storage.repository.StorageRepository;
import com.fridgemanager.fridgemanager.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {

    private StorageRepository storageRepository;

    private UserRepository userRepository;

    private ProductRepository productRepository;

    private DishRepository dishRepository;

    private ItemMapperProducer mapper;


    public StorageService(StorageRepository storageRepository, UserRepository userRepository,
                          ProductRepository productRepository, DishRepository dishRepository, ItemMapperProducer mapper) {
        this.storageRepository = storageRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.dishRepository = dishRepository;
        this.mapper = mapper;
    }

    public void addDish(String userName, StoredItemDto storedDishDto) {
        Storage storage = storageRepository.getStorageByUser(userName);
        StoredItemMapper mapper = this.mapper.getMapper(storedDishDto);
        StoredDish dish = (StoredDish) mapper.map(storedDishDto);
        storage.addDish(dish);
    }

    public void addProduct(String userName, StoredItemDto storedProductDto) {
        Storage storage = storageRepository.getStorageByUser(userName);
        StoredItemMapper mapper = this.mapper.getMapper(storedProductDto);
        StoredProduct product = (StoredProduct) mapper.map(storedProductDto);
        storage.addProduct(product);
    }

    public void removeDish(String userName, String dishName) {
        Storage storage = storageRepository.getStorageByUser(userName);
        storage.removeDish(dishName);
    }

    public void removeProduct(String userName, String productName) {
        Storage storage = storageRepository.getStorageByUser(userName);
        storage.removeProduct(productName);
    }

    public void updateDish(String userName, StoredItemDto storedDishDto) {
        StoredItemMapper mapper = this.mapper.getMapper(storedDishDto);
        Storage storage = storageRepository.getStorageByUser(userName);
    }

    public void updateProduct(String userName, StoredItemDto storedProductDto) {
        StoredItemMapper mapper = this.mapper.getMapper(storedProductDto);
        Storage storage = storageRepository.getStorageByUser(userName);
        storage.updateProduct((UpdateItemData) mapper.map(storedProductDto));
    }

    public Storage getStorage(String userName) {
        return null;
    }

    public List<StoredDish> getDishes(String userName) {
        return null;
    }

    public List<StoredProduct> getProducts(String userName) {
        return null;
    }
}
