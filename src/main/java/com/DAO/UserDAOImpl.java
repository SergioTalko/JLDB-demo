package com.DAO;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;
    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }



    @Override
    public Object create(Object o) {
        entityManager.persist(o);
        return o;
    }

    @Override
    public List<Object> getAll() {
        Session session = getSession();
        return session.createQuery("from User").list();
    }
}
