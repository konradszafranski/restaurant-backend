package com.wwsi.ti.idx8558.repository;

import com.wwsi.ti.idx8558.domain.Category;
import com.wwsi.ti.idx8558.domain.Dish;
import org.springframework.orm.hibernate5.HibernateQueryException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class DishRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public Dish getDish(String dishName) {
        try {
            Dish dish = (Dish) em.createQuery("SELECT d from Dish d WHERE d.dishName LIKE :name")
                    .setParameter("name", dishName)
                    .getSingleResult();
            System.out.println(dish);
            return dish;
        } catch(Exception e) {
            throw e;
        }
    }

    @Transactional
    public List<Dish> getDishes() {
        try {
            List<Dish> dishList = em.createQuery("SELECT d from Dish d").getResultList();
            return dishList;
        } catch(HibernateQueryException e) {
            System.out.println(e.toString());
            throw e;
        } catch(Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    @Transactional
    public void createDishes() throws RuntimeException {
        Dish dish = new Dish("Łosoś", "prawdziwy ze szczypiorkiem", 41.90F,  Category.Dania_Główne);
        em.persist(dish);
        Dish dish2 = new Dish("Bigos", "z grzybami", 23.40F,  Category.Dania_Główne);
        em.persist(dish2);
        Dish dish3 = new Dish("Sushi", "rybne", 38.10F,  Category.Przystawki);
        em.persist(dish3);
        Dish dish4 = new Dish("Mięso z warzywami", "i frytki", 29.15F,  Category.Dania_Główne);
        em.persist(dish4);
        Dish dish5 = new Dish("Szaszłyki", "3 sztuki", 18.50F,  Category.Przystawki);
        em.persist(dish5);
        Dish dish6 = new Dish("Jajka z awokado", "na czarnym chlebie", 55.90F,  Category.Przystawki);
        em.persist(dish6);
        Dish dish7 = new Dish("Sernik malinowy", "z malinami", 16.70F,  Category.Desery);
        em.persist(dish7);
        Dish dish8 = new Dish("Zupa cebulowa", "i z papryką", 19.20F,  Category.Zupy);
        em.persist(dish8);
        Dish dish9 = new Dish("Sałatka wiosenna", "z pomidorami i awokado", 14.10F,  Category.Przystawki);
        em.persist(dish9);
        Dish dish10 = new Dish("Pancakes", "z syropem klonowym", 21.80F,  Category.Desery);
        em.persist(dish10);
        Dish dish11 = new Dish("Piernik", "z syropem czekoladowym", 18.80F,  Category.Desery);
        em.persist(dish11);
        Dish dish12 = new Dish("Makaron z fasolą", "zapiekany", 32.60F,  Category.Dania_Główne);
        em.persist(dish12);
        Dish dish13 = new Dish("Kurczak ze szpinakiem", "z sosem koperkowym", 39.90F,  Category.Dania_Główne);
        em.persist(dish13);
        Dish dish14 = new Dish("Sałatka ogórkowa", "i z cebulą", 9.90F,  Category.Przystawki);
        em.persist(dish14);
        Dish dish15 = new Dish("Ciasto czekoladowe", "z gorzkiej czekolady", 19.90F,  Category.Desery);
        em.persist(dish15);
        Dish dish16 = new Dish("Tarta owoce leśne", "z mailnami i jagodami", 18.50F,  Category.Desery);
        em.persist(dish16);
        Dish dish17 = new Dish("Zupa chili", "dużo chili", 22.30F,  Category.Zupy);
        em.persist(dish17);
        Dish dish18 = new Dish("Zupa dyniowa", "z dyni", 21.20F,  Category.Zupy);
        em.persist(dish18);
    }
}
