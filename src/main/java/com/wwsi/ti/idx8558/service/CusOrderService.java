package com.wwsi.ti.idx8558.service;

import com.wwsi.ti.idx8558.domain.CusOrder;
import com.wwsi.ti.idx8558.generator.KeyGenerator;
import com.wwsi.ti.idx8558.models.DishModel;
import com.wwsi.ti.idx8558.repository.CusOrderRepository;
import com.wwsi.ti.idx8558.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CusOrderService {

    @Autowired
    CusOrderRepository cusOrderRepository;

    @Autowired
    DishRepository dishRepository;

    @Autowired
    KeyGenerator keyGenerator;

    public void saveCusOrder(List<DishModel> dishModelList) {
        CusOrder cusOrder = createCusOrder();

        for (DishModel dishModel : dishModelList) {
            cusOrder.addDish(dishRepository.getDish(dishModel.getDishName()));
        }
        cusOrderRepository.saveCusOrder(cusOrder);
    }

    private CusOrder createCusOrder() {
        CusOrder cusOrder = new CusOrder();
        cusOrder.setCusOrderTime(LocalDateTime.now());
        cusOrder.setDeliveryTime(LocalDateTime.now().plusHours(1));
        cusOrder.setCusOrderNumber(keyGenerator.generateKey(cusOrder.getCusOrderTime()));

        return cusOrder;
    }
}
