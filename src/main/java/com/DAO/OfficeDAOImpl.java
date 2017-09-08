package com.DAO;

import com.Entity.Office;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OfficeDAOImpl implements OfficeDAO {

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
    public Office getOffice(String name) {
        String hql = "from Office f where f.name = :name";
        Query query = getSession().createQuery(hql);
        query.setParameter("name", name);

        return (Office) query.uniqueResult();
    }

    @Override
    public List<Object> getAll() {
        Session session = getSession();
        Query query = session.createQuery("from Office");
        List<Object> list = query.list();
        return list;
    }

    //todo
}
