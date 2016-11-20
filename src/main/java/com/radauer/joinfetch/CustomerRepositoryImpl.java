package com.radauer.joinfetch;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Andreas on 20.11.2016.
 */
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> getAllAsListByQuery() {
        return em.createQuery("select c from Customer c join fetch c.products order by c.id").getResultList();
    }
}
