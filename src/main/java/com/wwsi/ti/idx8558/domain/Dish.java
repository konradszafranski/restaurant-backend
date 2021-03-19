package com.wwsi.ti.idx8558.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Potrawy")
    private Long idDish;

    @Column(name = "nazwaPotrawy", unique = true, nullable = false)
    private String dishName;

    @Column(name = "opisPotrawy", unique = true, nullable = false)
    private String description;

    @Column(name = "cena", nullable = false)
    private Float price;

    @ManyToMany(mappedBy = "dishList")
    private List<CusOrder> cusOrderList;

    @Enumerated(EnumType.STRING)
    @Column(name = "kategoriaPotrawy", length = 50, nullable = false)
    private Category category;

    protected Dish() {
    }

    public Dish(String dishName, String description, Float price, Category category) {
        this.dishName = dishName;
        this.description = description;
        this.price = price;
        this.category = category;
        cusOrderList = new ArrayList<>();
    }

    public Long getIdDish() {
        return idDish;
    }

    public String getDishName() {
        return dishName;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public List<CusOrder> getCusOrderList() {
        return cusOrderList;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Potrawa{" +
                "id=" + idDish +
                ", nazwa='" + dishName + '\'' +
                ", opis='" + description + '\'' +
                '}';
    }

    //hashcode, equals -> bussinessKey (opis, nazwa)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return dishName.equals(dish.dishName) && description.equals(dish.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishName, description);
    }
}
