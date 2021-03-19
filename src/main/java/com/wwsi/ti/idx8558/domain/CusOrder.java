package com.wwsi.ti.idx8558.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CusOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_CusOrder")
    private Long idCusOrder;

    @Column(nullable = false)
    private String cusOrderNumber;

    // Data i godzina o której zamówienie zostało złożone
    @Column(nullable = false)
    private LocalDateTime cusOrderTime;

    // Data i godzina na którą zamówienie powinno zostać dostarczone
    @Column(nullable = false)
    private LocalDateTime deliveryTime;

    @ManyToOne
    @JoinColumn(name = "idCustomer")
    private Customer customer;

    @ManyToMany
    @Column(nullable = false)
    private List<Dish> dishList;

    public CusOrder() {
        dishList = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishList.add(dish);
    }

    public LocalDateTime getCusOrderTime() {
        return cusOrderTime;
    }

    public void setCusOrderTime(LocalDateTime cusOrderTime) {
        this.cusOrderTime = cusOrderTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getCusOrderNumber() {
        return cusOrderNumber;
    }

    public void setCusOrderNumber(String cusOrderNumber) {
        this.cusOrderNumber = cusOrderNumber;
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "id=" + idCusOrder +
                ", czasZamowienia=" + cusOrderTime +
                ", czasDostarczenia=" + deliveryTime +
                ", listaPotraw=" + dishList +
                '}';
    }
}
