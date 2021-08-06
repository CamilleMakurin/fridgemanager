package com.fridgemanager.fridgemanager.storage.controller;

import com.fridgemanager.fridgemanager.storage.domain.Storage;
import com.fridgemanager.fridgemanager.storage.domain.StoredDish;
import com.fridgemanager.fridgemanager.storage.domain.StoredItemDto;
import com.fridgemanager.fridgemanager.storage.domain.StoredProduct;
import com.fridgemanager.fridgemanager.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class StorageController {

    private final StorageService service;

    @Autowired
    public StorageController(StorageService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userName}/storage", produces = "application/json")
    public ResponseEntity<Storage> getStorage(@PathVariable(name = "userName") String userName) {
        Storage storage = service.getStorage(userName);
        return ResponseEntity.ok(storage);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userName}/storage/dish", produces = "application/json")
    public ResponseEntity<List<StoredDish>> getDishes(@PathVariable(name = "userName") String userName) {
        List<StoredDish> storedProducts = service.getDishes(userName);
        return ResponseEntity.ok(storedProducts);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userName}/storage/product", produces = "application/json")
    public ResponseEntity<List<StoredProduct>> getProducts(@PathVariable(name = "userName") String userName) {
        List<StoredProduct> storedProducts = service.getProducts(userName);
        return ResponseEntity.ok(storedProducts);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{userName}/storage/dish", consumes = "application/json")
    public ResponseEntity<String> addDish(@PathVariable(name = "userName") String userName, @RequestBody StoredItemDto storedDishDto) {
        service.addDish(userName, storedDishDto);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(method = RequestMethod.POST, path = "/{userName}/storage/product", consumes = "application/json")
    public ResponseEntity<String> addProduct(@PathVariable(name = "userName") String userName, @RequestBody StoredItemDto storedItemDto) {
        service.addProduct(userName, storedItemDto);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/{userName}/storage/{dishName}")
    public ResponseEntity<String> removeDish(@PathVariable(name = "userName") String userName,
                                             @PathVariable(name = "dishName") String dishName) {
        service.removeDish(userName, dishName);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{userName}/storage/{productName}")
    public ResponseEntity<String> removeProduct(@PathVariable(name = "userName") String userName,
                                                @PathVariable(name = "productName") String productName) {
        service.removeProduct(userName, productName);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{userName}/dish", consumes = "application/json")
    public ResponseEntity<String> updateDish(@PathVariable(name = "userName") String userName,
                                             @RequestBody StoredItemDto storedDishDto) {
        try {
            service.updateDish(userName, storedDishDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{userName}/dish", consumes = "application/json")
    public ResponseEntity<String> updateProduct(@PathVariable(name = "userName") String userName,
                                                @RequestBody StoredItemDto storedProductDto) {
        try {
            service.updateProduct(userName, storedProductDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
