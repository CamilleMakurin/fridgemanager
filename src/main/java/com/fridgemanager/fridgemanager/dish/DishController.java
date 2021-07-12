package com.fridgemanager.fridgemanager.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping("/dish")
public class DishController {

    private final DishService service;

    @Autowired
    public DishController(DishService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{dishName}", produces = "application/json")
    public ResponseEntity<Dish> getDish(@PathVariable(name = "dishName") String dishName) {
        Optional<Dish> dishOpt = service.getDish(dishName);
        return dishOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> createDish(@RequestBody Dish dish) {
        service.createDish(dish);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{dishName}")
    public ResponseEntity<String> deleteDish(@PathVariable(name = "dishName") String dishName) {
        service.deleteDish(dishName);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<String> updateDish(@RequestBody Dish dish) {
        try {
            service.updateDish(dish);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
