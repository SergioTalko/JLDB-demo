package com.DAO;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;



    @Override
    public Object create(Object o) {
        entityManager.persist(o);
        return o;
    }

    /*@Override
    public void delete(Object o) {
        entityManager.remove(o);
    }*/
}
