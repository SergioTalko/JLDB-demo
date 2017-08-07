package com.DAO;

import com.Entity.Office;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class OfficeDAOImpl implements OfficeDAO {

    @PersistenceContext
    EntityManager entityManager;

   /* public Session getSession() {
        return entityManager.unwrap(Session.class);
    }*/



    @Override
    public Object create(Object o) {
        entityManager.persist(o);
        return o;
    }

    /*@Override
    public void delete(Object o) {
       // entityManager.remove(o);
        Session session = getSession();
        Query query = session.createQuery("delete from Office where office_id = :office_id");
        query.setParameter("office_id", ((Office) o).getOffice_id());

        query.executeUpdate();
    }*/

    /*@Override
    public Office getOffice(String name) {
        Session session = getSession();
        Query query = session.createQuery("from Office where name =:name");
        query.setParameter("name", name);

        return (Office) query.uniqueResult();
    }*/

    //todo
}
