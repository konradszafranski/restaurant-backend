package com.wwsi.ti.idx8558.service;

import com.wwsi.ti.idx8558.domain.Dish;
import com.wwsi.ti.idx8558.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DishService {

    @Autowired
    DishRepository dishRepository;

    public List<Dish> getDishes() {
        return dishRepository.getDishes();
    }

    public void createDishes() {
        dishRepository.createDishes();
    }
}
