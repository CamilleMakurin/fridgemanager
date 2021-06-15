package com.fridgemanager.fridgemanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dish")
public class DishController {

    @RequestMapping(method = RequestMethod.GET, path = "/{dishName}")
    public ResponseEntity<String> createDish(@PathVariable(name = "dishName") String dishName){

    }


}
