package com.DAO;


import com.Entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
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
    public Object update(Object o) {
        Session session = getSession();
        session.update(o);
        return o;
    }

    @Override
    public List<Object> getAll() {
        Session session = getSession();
        return session.createQuery("from User").list();
    }

    @Override
    public User getUser(String user_name) {
        String hql = "from User f where f.user_name = :user_name";
        Query query = getSession().createQuery(hql);
        query.setParameter("user_name", user_name);

        return (User) query.uniqueResult();
    }

    @Override
    public List<User> getUsers(String name) {
        Session session = getSession();
        Query query = session.createQuery("from User f where f.user_name = :user_name");
        query.setParameter("user_name", name);
        //TODO: Check
        List<User> list = query.list();

        if (list.isEmpty())
            return null;
        return list;
    }



}
