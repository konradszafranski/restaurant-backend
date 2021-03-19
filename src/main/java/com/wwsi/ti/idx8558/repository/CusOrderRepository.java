package com.wwsi.ti.idx8558.repository;

import com.wwsi.ti.idx8558.domain.CusOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CusOrderRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void saveCusOrder(CusOrder cusOrder) {
        em.persist(cusOrder);
    }
}
