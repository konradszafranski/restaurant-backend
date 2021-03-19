package com.wwsi.ti.idx8558.controller;

import com.wwsi.ti.idx8558.domain.Dish;
import com.wwsi.ti.idx8558.models.DishModel;
import com.wwsi.ti.idx8558.service.CusOrderService;
import com.wwsi.ti.idx8558.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ContentController {

    @Autowired
    DishService dishService;

    @Autowired
    CusOrderService cusOrderService;

    @GetMapping("/initDishContent")
    public ResponseEntity<String> initDishContent() {
        try {
            dishService.createDishes();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("content inicialized");
        } catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("content inicialization error");
        }
    }

    @GetMapping("/getMenuContent")
    @ResponseBody
    public Object getMenuContent() {
        System.out.println("request here - test method");

        try {
            List<Dish> resultList = dishService.getDishes();
            System.out.println(resultList);
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(resultList.toArray());
        } catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("content not found");
        }
    }

    @PostMapping(value = "/saveOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrder(@RequestBody List<DishModel> dishModelArray) {

        cusOrderService.saveCusOrder(dishModelArray);
    }
}
